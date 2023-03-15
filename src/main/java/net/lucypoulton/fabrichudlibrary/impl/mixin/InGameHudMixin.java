package net.lucypoulton.fabrichudlibrary.impl.mixin;

import net.lucypoulton.fabrichudlibrary.impl.FabricHudLibraryMod;
import net.minecraft.client.gui.hud.InGameHud;
import net.minecraft.client.util.math.MatrixStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(InGameHud.class)
public abstract class InGameHudMixin {
    @Shadow public abstract int getTicks();

    @Inject(method = "render", at = @At("TAIL"))
    public void render(MatrixStack matrices, float tickDelta, CallbackInfo ci) {
        FabricHudLibraryMod.getInstance().renderer.render(getTicks());
    }
}
