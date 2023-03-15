package net.lucypoulton.fabrichudlibrary.api;

import net.minecraft.client.gui.DrawableHelper;
import net.minecraft.client.util.math.MatrixStack;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.Range;

/**
 * An element rendered in a HUD.
 */
public abstract class HudElement {

    public abstract int height();

    public abstract int width();

    public abstract int x();

    public abstract int y();

    protected void renderBackground(MatrixStack matrices, @Range(from = 0, to = 255) int opacity) {
        DrawableHelper.fill(matrices, 0, 0, width(), height(), opacity << 24);
    }


    public abstract void render(MatrixStack matrices, int ticks, @Nullable MouseState mouseState);
}
