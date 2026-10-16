package cn.flowerinsnow.greatscrollabletooltips.object;

import cn.flowerinsnow.greatscrollabletooltips.common.object.ScrollSession;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.screens.inventory.tooltip.ClientTooltipComponent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.List;

/**
 * <p>记录 GUI 层 tooltip 的渲染状态</p>
 * <p>无论 tooltip 由谁渲染（原版槽位、JEI、EMI 或其它模组），只要经过
 * {@code GuiGraphics.renderTooltipInternal} 就会被记录，用于判断
 * “当前是否有 tooltip 正在显示”以及“tooltip 内容是否发生变化”（自动回正）</p>
 */
@OnlyIn(Dist.CLIENT)
public class TooltipRenderState {
    /**
     * <p>超过该时间（纳秒）没有渲染 tooltip 就认为 tooltip 已消失</p>
     * <p>使用墙钟而不是 tick 计数，避免低帧率下（一帧执行多个 tick）误判为消失</p>
     */
    private static final long SHOWING_TIMEOUT_NANOS = 250_000_000L;

    /**
     * <p>最后一次渲染 tooltip 的时间（{@link System#nanoTime()}）</p>
     */
    private long lastRenderedNanos = Long.MIN_VALUE / 4;
    /**
     * <p>上一次 tick 结束时 tooltip 是否正在显示（用于检测“刚消失”的跳变）</p>
     */
    private boolean wasShowing;
    /**
     * <p>当前 tick 内最后一次渲染的 tooltip 内容指纹</p>
     */
    private int frameFingerprint;
    /**
     * <p>上一次 tick 结束时确认的 tooltip 内容指纹</p>
     * <p>-1 表示未知</p>
     */
    private int lastFingerprint = -1;
    /**
     * <p>当前 tick 内是否渲染过 tooltip</p>
     */
    private boolean renderedSinceLastTick;

    /**
     * <p>每次渲染 tooltip 时调用（渲染帧，同一帧可能被调用多次）</p>
     *
     * @param components 当前渲染的 tooltip 内容
     * @param font 字体（用于计算内容指纹）
     */
    public void onTooltipRendered(List<ClientTooltipComponent> components, Font font) {
        this.lastRenderedNanos = System.nanoTime();
        this.frameFingerprint = fingerprintOf(components, font);
        this.renderedSinceLastTick = true;
    }

    /**
     * <p>标记 tooltip 正在显示</p>
     * <p>用于不经过 {@code GuiGraphics.renderTooltipInternal} 的第三方 tooltip 渲染模组</p>
     */
    public void markShowing() {
        this.lastRenderedNanos = System.nanoTime();
    }

    /**
     * <p>每 tick 末调用</p>
     * <p>以 tick 为粒度比较指纹：同一 tick 内渲染多个不同 tooltip（例如 JEI 物品列表与容器槽位
     * 几何重叠）时只取最后一个，避免指纹来回抖动导致每帧误回正</p>
     *
     * @param session 当前滚动会话
     * @param autoReset 是否开启自动回正
     */
    public void onTick(ScrollSession<?> session, boolean autoReset) {
        boolean showing = this.isShowing();

        if (this.renderedSinceLastTick) {
            if (this.lastFingerprint != -1 && this.frameFingerprint != this.lastFingerprint
                    && autoReset && (session.getHorizontal() != 0 || session.getVertical() != 0)) {
                // tooltip 内容发生变化（切换到了其它物品），自动回正
                session.resetScroll();
            }
            this.lastFingerprint = this.frameFingerprint;
            this.renderedSinceLastTick = false;
        }

        if (this.wasShowing && !showing && autoReset) {
            // tooltip 刚刚消失，自动回正
            session.resetScroll();
        }
        this.wasShowing = showing;
    }

    /**
     * <p>当前是否有 tooltip 正在显示</p>
     */
    public boolean isShowing() {
        return System.nanoTime() - this.lastRenderedNanos < SHOWING_TIMEOUT_NANOS;
    }

    /**
     * <p>重置全部状态（切换界面时调用）</p>
     */
    public void reset() {
        this.lastRenderedNanos = Long.MIN_VALUE / 4;
        this.wasShowing = false;
        this.lastFingerprint = -1;
        this.renderedSinceLastTick = false;
    }

    /**
     * <p>计算 tooltip 内容的指纹</p>
     * <p>使用组件类型与尺寸做廉价哈希，用于判断 tooltip 是否切换到了另一个物品</p>
     */
    private static int fingerprintOf(List<ClientTooltipComponent> components, Font font) {
        int result = 1;
        for (ClientTooltipComponent component : components) {
            result = result * 31 + component.getClass().hashCode();
            result = result * 31 + component.getWidth(font);
            result = result * 31 + component.getHeight();
        }
        return result;
    }
}
