package utils;

import java.util.Random;
import java.util.List;

public class RandomUtils {
    public static String getRandomString(int length) {
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder result = new StringBuilder();
        Random rnd = new Random();
        while (result.length() < length) {
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            result.append(SALTCHARS.charAt(index));
        }

        return result.toString();
    }

    public static String getRandomEmail() {
        return getRandomString(10) + "@yagmail.com";
    }

    public String getRandomElementFromList(List<String> elements) {
        Random rand = new Random();
        return elements.get(rand.nextInt(elements.size()));
    }

    public String getRandomSubject() {
        List<String> subjects = List.of("Maths", "English", "Chemistry", "Computer Science", "Commerce", "Arts", "History");
        return getRandomElementFromList(subjects);
    }

    public String getRandomHobby() {
        List<String> hobbies = List.of("Sports", "Reading", "Music");
        return getRandomElementFromList(hobbies);
    }


}

