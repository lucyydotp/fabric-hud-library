package net.lucypoulton.fabrichudlibrary.impl;

import net.lucypoulton.fabrichudlibrary.api.HudElement;
import net.lucypoulton.fabrichudlibrary.api.MouseState;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawableHelper;
import net.minecraft.client.util.math.MatrixStack;

import java.util.ArrayDeque;
import java.util.Deque;

public class HudRenderer extends DrawableHelper {

    private final MinecraftClient client;
    private final Deque<HudElement> elements = new ArrayDeque<>();

    private int scrollDelta;
    private boolean mouseClicked;


    public HudRenderer(MinecraftClient client) {
        this.client = client;
    }

    private static int absolute(int coord, int dimension, int screenSize) {
        if (coord >= 0) return coord;
        return screenSize + coord - dimension;
    }

    public void add(final HudElement element) {
        elements.add(element);
    }

    public void remove(final HudElement element) {
        elements.remove(element);
    }

    public void setMouseClicked(boolean clicked) {
        this.mouseClicked = clicked;
    }

    public void setScrollDelta(int delta) {
        this.scrollDelta = delta;
    }

    public void render(int ticks) {
        final var windowWidth = client.getWindow().getScaledWidth();
        final var windowHeight = client.getWindow().getScaledHeight();

        final var scaleFactor = (float) windowHeight / client.getWindow().getHeight();

        final var stack = new MatrixStack();
        final int mouseX = (int) (client.mouse.getX() * scaleFactor);
        final int mouseY = (int) (client.mouse.getY() * scaleFactor);

        for (final var element : elements) {
            final var x = absolute(element.x(), element.width(), windowWidth);
            final var y = absolute(element.y(), element.height(), windowHeight);
            stack.push();
            stack.translate(x, y, 0);
            final var mouseState = mouseX >= x && mouseX < (x + element.width()) &&
                    mouseY >= y && mouseY < (y + element.height()) ?
                    new MouseState(mouseX - x, mouseY - y, mouseX, mouseY, scrollDelta, mouseClicked) :
                    null;

            element.render(stack, ticks, mouseState);
            stack.pop();
        }
        this.scrollDelta = 0;
    }
}
