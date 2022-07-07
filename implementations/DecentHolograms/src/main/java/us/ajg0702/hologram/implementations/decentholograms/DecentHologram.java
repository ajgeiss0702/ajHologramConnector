package us.ajg0702.hologram.implementations.decentholograms;

import eu.decentsoftware.holograms.api.DHAPI;
import eu.decentsoftware.holograms.api.actions.Action;
import eu.decentsoftware.holograms.api.actions.ActionType;
import eu.decentsoftware.holograms.api.actions.ClickType;
import net.kyori.adventure.text.serializer.legacy.LegacyComponentSerializer;
import org.bukkit.Location;
import us.ajg0702.hologram.api.Hologram;
import us.ajg0702.hologram.api.HologramManager;
import us.ajg0702.hologram.api.HologramPage;
import us.ajg0702.hologram.api.Utils;
import us.ajg0702.hologram.api.lines.HeadLine;
import us.ajg0702.hologram.api.lines.HologramLine;
import us.ajg0702.hologram.api.lines.TextLine;

import java.util.List;

public class DecentHologram extends Hologram {

    private static final LegacyComponentSerializer legacyComponentSerializer = LegacyComponentSerializer.legacyAmpersand();
    private final eu.decentsoftware.holograms.api.holograms.Hologram hologram;

    public DecentHologram(HologramManager hologramManager, Location location, List<HologramPage> pages) {
        super(hologramManager, location, pages);

        hologram = DHAPI.createHologram("ajh-"+Utils.randomAlphaNumeric(), location.clone());
        updatePages();
    }

    public eu.decentsoftware.holograms.api.holograms.Hologram getHologram() {
        return hologram;
    }

    @Override
    public void updatePages() {
        int i = 0;
        for (eu.decentsoftware.holograms.api.holograms.HologramPage page : hologram.getPages()) {
            hologram.removePage(i++);
        }

        i = 0;
        for (HologramPage page : pages) {
            eu.decentsoftware.holograms.api.holograms.HologramPage decentPage = hologram.addPage();

            for (HologramLine line : page.getLines()) {
                if(line.isText()) {
                    TextLine textLine = (TextLine) line;
                    decentPage.addLine(DHAPI.createHologramLine(decentPage, legacyComponentSerializer.serialize(textLine.getText())));
                } else if(line.isHead()) {
                    HeadLine headLine = (HeadLine) line;
                    decentPage.addLine(DHAPI.createHologramLine(decentPage, "#HEAD: " + headLine.getHeadItem().getType()));

                }
            }

            if(i == 0) {
                decentPage.addAction(ClickType.LEFT, new Action(ActionType.NEXT_PAGE, null));
                decentPage.addAction(ClickType.RIGHT, new Action(ActionType.PAGE, pages.size()+""));
            } else if(i == pages.size()) {
                decentPage.addAction(ClickType.LEFT, new Action(ActionType.PAGE, "1"));
                decentPage.addAction(ClickType.RIGHT, new Action(ActionType.PREV_PAGE, null));
            } else {
                decentPage.addAction(ClickType.LEFT, new Action(ActionType.NEXT_PAGE, null));
                decentPage.addAction(ClickType.RIGHT, new Action(ActionType.PREV_PAGE, null));
            }

            i++;
        }
    }
}
