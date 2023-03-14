package net.lucypoulton.fabrichudlibrary.impl.test;

import net.lucypoulton.fabrichudlibrary.api.HudElement;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawableHelper;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.ColorHelper;

/**
 * A simple test element.
 */
public class TestElement extends HudElement {

    private final int x;
    private final int y;

    public TestElement(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int height() {
        return MinecraftClient.getInstance().textRenderer.fontHeight * 2 + 12;
    }

    @Override
    public int width() {
        return 70;
    }

    @Override
    public int x() {
        return x;
    }

    @Override
    public int y() {
        return y;
    }

    @Override
    public void render(MatrixStack matrices, boolean hasFocus) {
        renderBackground(matrices, 127);
        final var text = MinecraftClient.getInstance().textRenderer;
        DrawableHelper.drawCenteredTextWithShadow(matrices, text, "Test element", width() / 2, 6,
                ColorHelper.Argb.getArgb(255, 255, 255, 255));
        DrawableHelper.drawCenteredTextWithShadow(matrices, text, "X " + x() + " Y " + y(), width() / 2, 6 + text.fontHeight,
                ColorHelper.Argb.getArgb(255, 255, 255, 255));
    }
}
