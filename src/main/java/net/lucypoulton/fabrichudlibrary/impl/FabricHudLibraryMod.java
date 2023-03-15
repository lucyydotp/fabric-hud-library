package net.lucypoulton.fabrichudlibrary.impl;

import net.minecraft.client.MinecraftClient;

public class FabricHudLibraryMod {
    private static final FabricHudLibraryMod instance = new FabricHudLibraryMod();

    public static FabricHudLibraryMod getInstance() {
        return instance;
    }

    private FabricHudLibraryMod() {
        renderer = new HudRenderer(MinecraftClient.getInstance());
    }

    public final HudRenderer renderer;
}
