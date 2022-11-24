package us.ajg0702.hologram.api;

import us.ajg0702.hologram.api.lines.HologramLine;

import java.util.List;

public class HologramPage {
    private final List<HologramLine> lines;

    public HologramPage(List<HologramLine> lines) {
        this.lines = lines;
    }

    public List<HologramLine> getLines() {
        return lines;
    }

    @Override
    public String toString() {
        return lines.toString();
    }
}
