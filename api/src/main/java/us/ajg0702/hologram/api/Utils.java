package us.ajg0702.hologram.api;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Utils {
    private static final Random random = new Random();
    private static final List<Character> chars = new ArrayList<>();
    static {
        for (int i = 'a'; i <= 'z'; i++) {
            chars.add((char) i);
        }
        for (int i = '0'; i <= '9'; i++) {
            chars.add((char) i);
        }
    }

    public static String randomAlphaNumeric() {
        StringBuilder string = new StringBuilder();
        for (int i = 1; i <= 10; i++) {
            string.append(chars.get(randomInt(0, chars.size()-1)));
        }
        return string.toString();
    }

    public static int randomInt(int min, int max) {
        return random.nextInt(max-min)+min;
    }
}
