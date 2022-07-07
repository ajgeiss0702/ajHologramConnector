package us.ajg0702.hologram.api.lines;

public class HologramLine {
    public boolean isText() {
        return this instanceof TextLine;
    }
    public boolean isHead() {
        return this instanceof HeadLine;
    }
}
