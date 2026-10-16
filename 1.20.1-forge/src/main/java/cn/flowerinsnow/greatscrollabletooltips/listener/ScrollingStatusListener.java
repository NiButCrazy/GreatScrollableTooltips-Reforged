package cn.flowerinsnow.greatscrollabletooltips.listener;

import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import cn.flowerinsnow.greatscrollabletooltips.GreatScrollableTooltips;
import cn.flowerinsnow.greatscrollabletooltips.event.RenderTooltipEvent;
import cn.flowerinsnow.greatscrollabletooltips.event.ScreenCloseEvent;
import cn.flowerinsnow.greatscrollabletooltips.common.object.ScrollSession;

import java.util.Objects;

/**
 * 处理滚动状态
 */
public record ScrollingStatusListener(GreatScrollableTooltips main) {
    public ScrollingStatusListener(GreatScrollableTooltips main) {
        this.main = Objects.requireNonNull(main);
    }

    @SubscribeEvent
    public void preRenderTooltip(RenderTooltipEvent.Pre event) {
        ScrollSession<ItemStack> session = this.main.getScrollSession();
        // 标记 tooltip 正在显示（兼容不经过 GuiGraphics.renderTooltipInternal 的第三方 tooltip 渲染模组）
        this.main.getTooltipRenderState().markShowing();

        ItemStack itemStack = event.getSlot().getItem();
        if (itemStack != session.getLastItemStackRendered()) { // 如果正在渲染的物品和上一次渲染的物品不是同一个
            session.setLastItemStackRendered(itemStack);

            if (this.main.getConfig().autoReset) { // 仅当自动回正开启时自动回正
                session.resetScroll();
            }
        }
    }

    @SubscribeEvent
    public void missRenderTooltip(RenderTooltipEvent.Miss event) {
        // 仅清除原版槽位渲染状态（供滚轮判定用）；不重置滚动量，避免在 JEI/EMI 中每帧清零按键滚动量
        ScrollSession<ItemStack> session = this.main.getScrollSession();
        session.setLastItemStackRendered(null);
    }

    @SubscribeEvent
    public void onScreenClose(ScreenCloseEvent event) {
        ScrollSession<ItemStack> session = this.main.getScrollSession();
        session.setLastItemStackRendered(null);
        session.resetScroll();
        this.main.getTooltipRenderState().reset();
    }
}
