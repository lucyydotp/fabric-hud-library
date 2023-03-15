package net.lucypoulton.fabrichudlibrary.impl.mixin;

import net.lucypoulton.fabrichudlibrary.impl.FabricHudLibraryMod;
import net.minecraft.client.Mouse;
import org.lwjgl.glfw.GLFW;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Mouse.class)
public class MouseMixin {

    @Inject(method = "onMouseButton",
            at=@At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/client/MinecraftClient;getOverlay()Lnet/minecraft/client/gui/screen/Overlay;",
                    ordinal = 0,
                    shift = At.Shift.AFTER
            )
    )
    public void onClick(long window, int button, int action, int mods, CallbackInfo ci) {
        FabricHudLibraryMod.getInstance().renderer.setMouseClicked(action == GLFW.GLFW_PRESS);
    }

    @Inject(method = "onMouseScroll",
    at=@At(
            value = "INVOKE",
            target = "Lnet/minecraft/client/MinecraftClient;getOverlay()Lnet/minecraft/client/gui/screen/Overlay;",
            shift = At.Shift.AFTER
    ))
    public void onScroll(long window, double horizontal, double vertical, CallbackInfo ci) {
        FabricHudLibraryMod.getInstance().renderer.setScrollDelta((int) Math.signum(vertical));
    }
}
