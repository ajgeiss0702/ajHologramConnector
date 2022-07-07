package us.ajg0702.hologram.api;

import org.bukkit.Location;

import java.util.List;

public abstract class Hologram {

    protected final HologramManager hologramManager;
    protected final Location location;
    protected List<HologramPage> pages;

    public Hologram(HologramManager hologramManager, Location location, List<HologramPage> pages) {
        this.hologramManager = hologramManager;
        if(location == null) throw new IllegalArgumentException("location cannot be null!");
        if(location.getWorld() == null) throw new IllegalArgumentException("location world cannot be null!");
        this.location = location.clone();
        this.pages = pages;
    }

    public abstract void updatePages();

    public void setPages(List<HologramPage> pages) {
        this.pages = pages;
        updatePages();
    }

    public List<HologramPage> getPages() {
        return pages;
    }

    public void setPage(int index, HologramPage page) {
        pages.set(index, page);
        updatePages();
    }

    public void remove() {
        hologramManager.removeHologram(this);
    }

    public Location getLocation() {
        return location;
    }
}
