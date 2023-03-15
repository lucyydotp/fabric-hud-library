package net.lucypoulton.fabrichudlibrary.api;

import org.jetbrains.annotations.Range;

public record MouseState(
        @Range(from = 0, to = Integer.MAX_VALUE) int x,
        @Range(from = 0, to = Integer.MAX_VALUE) int y,
        boolean isClicked) {
}
