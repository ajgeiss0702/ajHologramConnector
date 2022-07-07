package us.ajg0702.hologram.implementations.bukkit;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.serializer.legacy.LegacyComponentSerializer;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.plugin.java.JavaPlugin;
import us.ajg0702.hologram.api.Hologram;
import us.ajg0702.hologram.api.HologramManager;
import us.ajg0702.hologram.api.HologramPage;
import us.ajg0702.hologram.api.lines.HologramLine;
import us.ajg0702.hologram.api.lines.TextLine;

import java.util.ArrayList;
import java.util.List;

public class BukkitHologram extends Hologram {
    public static final LegacyComponentSerializer legacyComponentSerializer = LegacyComponentSerializer.legacySection();
    private final JavaPlugin plugin;
    private final List<ArmorStand> entityLines = new ArrayList<>();
    public BukkitHologram(JavaPlugin plugin, HologramManager hologramManager, Location location, List<HologramPage> pages) {
        super(hologramManager, location, pages);
        this.plugin = plugin;

        updatePages();
    }

    public List<ArmorStand> getEntityLines() {
        return entityLines;
    }

    @Override
    public void updatePages() {
        List<Entity> oldEntites = new ArrayList<>(entityLines);
        entityLines.clear();
        if(pages.size() == 0) {
            oldEntites.forEach(Entity::remove);
        }

        HologramPage page = pages.get(0);

        double height = 0.3;

        Location addingLoc = location.clone().add(0, -1.78, 0).add(0, height * page.getLines().size(), 0);

        for (HologramLine line : page.getLines()) {
            if(!line.isText()) continue;
            TextLine textLine = (TextLine) line;
            Component text = textLine.getText();

            String legacyString = legacyComponentSerializer.serialize(text);

            Location finalLoc = addingLoc.clone();
            assert finalLoc.getWorld() != null;

            runOnMainThread(() -> {
                ArmorStand entity = (ArmorStand) finalLoc.getWorld().spawnEntity(finalLoc.clone(), EntityType.ARMOR_STAND);
                entity.setSmall(true);
                entity.setVisible(false);
                entity.setGravity(false);

                entity.setCustomName(legacyString);
                entity.setCustomNameVisible(true);

                entityLines.add(entity);

                if(oldEntites.size() > 0) {
                    oldEntites.get(0).remove();
                    oldEntites.remove(0);
                }
            });

            addingLoc.add(0, -height, 0);
        }
    }

    private void runOnMainThread(Runnable runnable) {
        if(Bukkit.isPrimaryThread()) {
            runnable.run();
            return;
        }
        Bukkit.getScheduler().runTask(plugin, runnable);
    }
}
