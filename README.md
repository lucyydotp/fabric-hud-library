# Lucy's Fabric HUD Library
 _A ridiculous attempt at adding stuff to the Minecraft HUD_

---

### Maven

Available in the `https://maven.lucypoulton.net/releases` repository under `net.lucypoulton:fabric-hud-library`.
Use JiJ through Fabric.

```kotlin
repositories {
    maven("https://maven.lucypoulton.net/releases")
}

dependencies {
    include(implementation("net.lucypoulton:fabric-hud-library:VERSION"))
}
```

### Usage

- Extend and instantiate `HudElement` for each element
- To render elements, access a `HudRenderer` through `FabricHudLibraryMod#hudRenderer` and call `#add(HudElement)`
