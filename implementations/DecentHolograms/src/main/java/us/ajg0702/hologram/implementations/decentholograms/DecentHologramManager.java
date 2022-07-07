package us.ajg0702.hologram.implementations.decentholograms;

import eu.decentsoftware.holograms.api.DHAPI;
import org.bukkit.Location;
import org.bukkit.plugin.java.JavaPlugin;
import us.ajg0702.hologram.api.Hologram;
import us.ajg0702.hologram.api.HologramManager;
import us.ajg0702.hologram.api.HologramPage;

import java.util.List;

public class DecentHologramManager extends HologramManager {
    public DecentHologramManager(JavaPlugin plugin) {
        super(plugin);
    }

    @Override
    protected Hologram constructHologram(Location location, List<HologramPage> pages) {
        return new DecentHologram(this, location, pages);
    }

    @Override
    protected void destroyHologram(Hologram hologram) {
        if(!(hologram instanceof DecentHologram)) {
            throw new IllegalArgumentException("That hologram is not from this implementation!");
        }
        DecentHologram decentHologram = (DecentHologram) hologram;
        DHAPI.removeHologram(decentHologram.getHologram().getName());
    }

    @Override
    public String getImplementationName() {
        return "DecentHolograms";
    }

    @Override
    public boolean supportsPages() {
        return true;
    }
}
