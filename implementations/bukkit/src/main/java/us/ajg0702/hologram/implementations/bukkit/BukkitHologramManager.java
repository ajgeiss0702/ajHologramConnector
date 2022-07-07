package us.ajg0702.hologram.implementations.bukkit;

import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.plugin.java.JavaPlugin;
import us.ajg0702.hologram.api.Hologram;
import us.ajg0702.hologram.api.HologramManager;
import us.ajg0702.hologram.api.HologramPage;

import java.util.List;

public class BukkitHologramManager extends HologramManager {

    public BukkitHologramManager(JavaPlugin plugin) {
        super(plugin);
    }

    @Override
    protected Hologram constructHologram(Location location, List<HologramPage> pages) {
        return new BukkitHologram(plugin, this, location, pages);
    }

    @Override
    protected void destroyHologram(Hologram hologram) {
        if(!(hologram instanceof BukkitHologram)) {
            throw new IllegalArgumentException("Supplied hologram is not from this implementation!");
        }
        BukkitHologram bukkitHologram = (BukkitHologram) hologram;

        bukkitHologram.getEntityLines().forEach(Entity::remove);
    }

    @Override
    public String getImplementationName() {
        return "Bukkit";
    }

    @Override
    public boolean supportsPages() {
        return false;
    }
}
