package net.lucypoulton.fabrichudlibrary.impl;

import net.lucypoulton.fabrichudlibrary.impl.test.TestElement;
import net.minecraft.client.MinecraftClient;

public class FabricHudLibraryMod {
    private static final FabricHudLibraryMod instance = new FabricHudLibraryMod();

    public static FabricHudLibraryMod getInstance() {
        return instance;
    }

    private FabricHudLibraryMod() {
        renderer = new HudRenderer(MinecraftClient.getInstance());
        renderer.add(new TestElement(5, 5));
        renderer.add(new TestElement(5, -15));
        renderer.add(new TestElement(-5, -15));
        renderer.add(new TestElement(-5, 5));
    }

    public final HudRenderer renderer;
}
