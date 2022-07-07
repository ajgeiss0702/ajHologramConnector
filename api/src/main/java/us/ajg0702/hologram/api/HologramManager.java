package us.ajg0702.hologram.api;

import org.bukkit.Location;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unused")
public abstract class HologramManager {

    protected final JavaPlugin plugin;

    public HologramManager(JavaPlugin plugin) {
        this.plugin = plugin;
    }


    protected abstract Hologram constructHologram(Location location, List<HologramPage> pages);
    protected abstract void destroyHologram(Hologram hologram);

    public abstract String getImplementationName();

    public abstract boolean supportsPages();

    public Hologram createHologram(Location location, List<HologramPage> pages) {
        Hologram hologram = constructHologram(location, pages);
        holograms.add(hologram);
        return hologram;
    }

    public void removeHologram(Hologram hologram) {
        destroyHologram(hologram);
        holograms.remove(hologram);
    }

    private final List<Hologram> holograms = new ArrayList<>();

    public List<Hologram> getHolograms() {
        return holograms;
    }

    public void shutdown() {
        holograms.forEach(this::destroyHologram);
        holograms.clear();
    }
}
