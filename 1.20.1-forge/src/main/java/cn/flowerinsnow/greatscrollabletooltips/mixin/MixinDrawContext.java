package cn.flowerinsnow.greatscrollabletooltips.mixin;

import cn.flowerinsnow.greatscrollabletooltips.GreatScrollableTooltips;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.tooltip.ClientTooltipComponent;
import net.minecraft.client.gui.screens.inventory.tooltip.ClientTooltipPositioner;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.objectweb.asm.Opcodes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.List;

@Mixin(GuiGraphics.class)
@OnlyIn(Dist.CLIENT)
public class MixinDrawContext {
    /**
     * <p>记录 tooltip 的渲染状态</p>
     * <p>无论 tooltip 由谁渲染（原版槽位、JEI、EMI 或其它模组），最终都会经过这里</p>
     */
    @Inject(
            method = "renderTooltipInternal",
            at = @At("HEAD")
    )
    private void onRenderTooltip(Font font, List<ClientTooltipComponent> components, int mouseX, int mouseY, ClientTooltipPositioner positioner, CallbackInfo ci) {
        if (components.isEmpty()) {
            return;
        }

        GreatScrollableTooltips instance = GreatScrollableTooltips.getInstance();
        if (instance == null || instance.getConfig() == null) {
            return;
        }

        instance.getTooltipRenderState().onTooltipRendered(components, font);
    }

    @ModifyVariable(
            method = "renderTooltipInternal",
            at = @At(
                    value = "STORE",
                    ordinal = 0,
                    opcode = Opcodes.ISTORE
            ),
            index = 12
    )
    private int modifyX(int x) {
        GreatScrollableTooltips instance = GreatScrollableTooltips.getInstance();
        return x + (instance.getScrollSession().getHorizontal() * instance.getConfig().sensitivity);
    }

    @ModifyVariable(
            method = "renderTooltipInternal",
            at = @At(
                    value = "STORE",
                    ordinal = 0,
                    opcode = Opcodes.ISTORE
            ),
            index = 13
    )
    private int modifyY(int y) {
        GreatScrollableTooltips instance = GreatScrollableTooltips.getInstance();
        return y + (instance.getScrollSession().getVertical() * instance.getConfig().sensitivity);
    }
}
