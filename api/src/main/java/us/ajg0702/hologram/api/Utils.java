package us.ajg0702.hologram.api;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.serializer.plain.PlainTextComponentSerializer;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Utils {
    private static final PlainTextComponentSerializer PLAIN_TEXT_COMPONENT_SERIALIZER
            = PlainTextComponentSerializer.plainText();
    private static final Random RANDOM = new Random();
    private static final List<Character> CHARACTERS = new ArrayList<>();
    static {
        for (int i = 'a'; i <= 'z'; i++) {
            CHARACTERS.add((char) i);
        }
        for (int i = '0'; i <= '9'; i++) {
            CHARACTERS.add((char) i);
        }
    }

    public static String randomAlphaNumeric() {
        StringBuilder string = new StringBuilder();
        for (int i = 1; i <= 10; i++) {
            string.append(CHARACTERS.get(randomInt(0, CHARACTERS.size()-1)));
        }
        return string.toString();
    }

    public static int randomInt(int min, int max) {
        return RANDOM.nextInt(max-min)+min;
    }

    public static String plainText(Component component) {
        return PLAIN_TEXT_COMPONENT_SERIALIZER.serialize(component);
    }
}
