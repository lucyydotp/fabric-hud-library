package net.lucypoulton.fabrichudlibrary.api;

import org.jetbrains.annotations.Range;

public interface MouseEvent {
    interface ButtonUp extends ButtonEvent {
    }

    interface ButtonDown extends ButtonEvent {
    }

    interface Move extends XYMouseEvent {
    }

    interface Scroll extends MouseEvent {
        int amount();
    }
}

interface XYMouseEvent extends MouseEvent {
    int x();

    int y();
}

interface ButtonEvent extends XYMouseEvent {
    @Range(from = 0, to = Integer.MAX_VALUE)
    int button();
}
