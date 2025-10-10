package practice04;

import java.util.HashSet;

public class LongestUniqueSubstring {

    // Function to find the length of the longest substring without repeating characters
    public static int longestUniqueSubstring(String s) {
        int n = s.length();
        int maxLength = 0;
        int left = 0; // Start of the window

        HashSet<Character> set = new HashSet<>();

        for (int right = 0; right < n; right++) {
            char currentChar = s.charAt(right);

            // If character is already in set, shrink the window from the left
            while (set.contains(currentChar)) {
                set.remove(s.charAt(left));
                left++;
            }

            // Add current character and update maxLength
            set.add(currentChar);
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }

    public static void main(String[] args) {
        String str = "abcabcbb";
        int result = longestUniqueSubstring(str);
        System.out.println("Length of the longest substring without repeating characters: " + result);
    }
}