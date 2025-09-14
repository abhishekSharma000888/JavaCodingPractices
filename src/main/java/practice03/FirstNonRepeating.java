package practice03;

import java.util.LinkedHashMap;
import java.util.Map;

public class FirstNonRepeating {
    public static void main(String[] args) {
        String input = "aabbcddeff";
        Map<Character, Integer> freq = new LinkedHashMap<>();

        for (char c : input.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }

        for (Map.Entry<Character, Integer> entry : freq.entrySet()) {
            if (entry.getValue() == 1) {
                System.out.println("First non-repeating: " + entry.getKey());
                return;
            }
        }
        System.out.println("No non-repeating character found.");
    }
}
