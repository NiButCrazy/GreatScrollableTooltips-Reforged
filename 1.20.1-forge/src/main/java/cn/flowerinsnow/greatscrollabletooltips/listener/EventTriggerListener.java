package cn.flowerinsnow.greatscrollabletooltips.listener;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.Screen;
import net.minecraftforge.client.event.ScreenEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import cn.flowerinsnow.greatscrollabletooltips.GreatScrollableTooltips;
import cn.flowerinsnow.greatscrollabletooltips.event.ClientTickEndEvent;
import cn.flowerinsnow.greatscrollabletooltips.event.PreScreenKeyPressedEvent;
import cn.flowerinsnow.greatscrollabletooltips.event.ScreenCloseEvent;

public class EventTriggerListener {
    @SubscribeEvent
    public void onClientTickEnd(TickEvent.ClientTickEvent event) {
        if (event.phase == TickEvent.Phase.END) {
            GreatScrollableTooltips main = GreatScrollableTooltips.getInstance();
            if (main != null) {
                // 推进 tooltip 渲染状态（检测 tooltip 消失/内容变化后自动回正）
                main.getTooltipRenderState().onTick(main.getScrollSession(), main.getConfig().autoReset);
            }
            MinecraftForge.EVENT_BUS.post(new ClientTickEndEvent());
        }
    }

    @SubscribeEvent
    public void onScreenKeyPressed(ScreenEvent.KeyPressed.Pre event) {
        // 使用 Forge 的按键事件而不是注入 Screen.keyPressed：
        // JEI 配方界面（RecipesGui）等屏幕覆盖了 keyPressed 且不调用 super，注入会失效
        MinecraftForge.EVENT_BUS.post(new PreScreenKeyPressedEvent(
                event.getScreen(), event.getKeyCode(), event.getScanCode(), event.getModifiers()));
    }

    private Screen oldScreen;
    @SubscribeEvent
    public void onScreenClose(ClientTickEndEvent event) {
        Screen currentScreen = Minecraft.getInstance().screen;
        if (this.oldScreen != currentScreen) {
            if (this.oldScreen != null) {
                MinecraftForge.EVENT_BUS.post(new ScreenCloseEvent(this.oldScreen));
            }
            this.oldScreen = currentScreen;
        }
    }
}
