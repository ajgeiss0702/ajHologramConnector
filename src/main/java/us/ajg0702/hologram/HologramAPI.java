package us.ajg0702.hologram;

import org.bukkit.plugin.java.JavaPlugin;
import us.ajg0702.hologram.api.HologramManager;
import us.ajg0702.hologram.implementations.bukkit.BukkitHologramManager;

public class HologramAPI {
    private static HologramManager hologramManager;

    public static HologramManager getHologramManager() {
        return hologramManager;
    }

    public static void setHologramManager(HologramManager hologramManager) {
        if(HologramAPI.hologramManager != null) {
            throw new IllegalStateException("HologramManager is already set!");
        }
        HologramAPI.hologramManager = hologramManager;
    }

    public static void initialize(JavaPlugin plugin) {

        if(HologramAPI.hologramManager != null) {
            throw new IllegalStateException("HologramManager is already set!");
        }

        hologramManager = new BukkitHologramManager(plugin);

    }
}
