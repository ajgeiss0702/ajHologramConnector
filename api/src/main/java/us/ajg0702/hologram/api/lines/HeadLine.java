package us.ajg0702.hologram.api.lines;

import org.bukkit.inventory.ItemStack;

public class HeadLine extends HologramLine {
    private final ItemStack headItem;

    public HeadLine(ItemStack headItem) {
        this.headItem = headItem;
    }

    public ItemStack getHeadItem() {
        return headItem;
    }

    @Override
    public String toString() {
        return "HeadLine{" +
                "headItem=" + headItem +
                '}';
    }
}
