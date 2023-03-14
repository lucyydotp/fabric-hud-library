package net.lucypoulton.fabrichudlibrary.impl;

import net.lucypoulton.fabrichudlibrary.api.HudElement;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawableHelper;
import net.minecraft.client.util.math.MatrixStack;

import java.util.ArrayDeque;
import java.util.Deque;

public class HudRenderer extends DrawableHelper {

    private final MinecraftClient client;
    private final Deque<HudElement> elements = new ArrayDeque<>();


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

    public void render() {
        final var windowWidth = client.getWindow().getScaledWidth();
        final var windowHeight = client.getWindow().getScaledHeight();

        final var stack = new MatrixStack();

        for (final var element : elements) {
            final var x = absolute(element.x(), element.width(), windowWidth);
            final var y = absolute(element.y(), element.height(), windowHeight);
            stack.push();
            stack.translate(x, y, 0);
            element.render(stack, false);
            stack.pop();
        }
    }
}
