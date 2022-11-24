package us.ajg0702.hologram.api.lines;

import net.kyori.adventure.text.Component;
import us.ajg0702.hologram.api.Utils;

public class TextLine extends HologramLine {
    private final Component text;

    public TextLine(Component text) {
        this.text = text;
    }

    public Component getText() {
        return text;
    }

    @Override
    public String toString() {
        return "TextLine{" +
                "text=" + Utils.plainText(text) +
                '}';
    }
}
