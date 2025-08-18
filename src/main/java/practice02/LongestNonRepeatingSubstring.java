package practice02;

import java.util.HashSet;

public class LongestNonRepeatingSubstring {

    public static void main(String[] args) {

        String input = "bbbbb";

        System.out.println("The longest non-repeating substring is: "+
                longestNonRepeatingSubstring(input));

    }

    public static String longestNonRepeatingSubstring(String s){
        int i = 0, j = 0, startIndex = 0, maxLength = 0;
        HashSet<Character> h1 = new HashSet<>();

        while (j < s.length()) {
            if (!h1.contains(s.charAt(j))) {
                h1.add(s.charAt(j));
                if (maxLength < j - i + 1) {
                    maxLength = j - i + 1;
                    startIndex = i;
                }
                j++;
            } else {
                h1.remove(s.charAt(i));
                i++;
            }
        }
        return s.substring(startIndex, startIndex + maxLength);
    }
}
