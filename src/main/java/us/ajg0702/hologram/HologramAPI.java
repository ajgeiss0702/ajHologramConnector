package us.ajg0702.hologram;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import us.ajg0702.hologram.api.HologramManager;
import us.ajg0702.hologram.implementations.bukkit.BukkitHologramManager;
import us.ajg0702.hologram.implementations.decentholograms.DecentHologramManager;

public class HologramAPI {
    private static HologramManager hologramManager;

    public static HologramManager getHologramManager() {
        return hologramManager;
    }

    public static void setHologramManager(HologramManager hologramManager) {
        if(HologramAPI.hologramManager != null) {
            HologramAPI.hologramManager.shutdown();
            hologramManager.getPlugin().getLogger().warning("Unloading previous HologramManager due to a new one being set!");
        }
        HologramAPI.hologramManager = hologramManager;
    }

    public static void initialize(JavaPlugin plugin) {

        if(Bukkit.getPluginManager().isPluginEnabled("DecentHolograms")) {
            setHologramManager(new DecentHologramManager(plugin));
        } else {
            setHologramManager(new BukkitHologramManager(plugin));
        }

    }
}
