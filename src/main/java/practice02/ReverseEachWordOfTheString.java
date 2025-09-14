package practice02;

public class ReverseEachWordOfTheString {

    public static void main(String[] args) {

        String input = "This is string";
        String reversed = "";
        String word = "";

        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);

            if (ch != ' ') {
                // Build the current word
                word = ch + word;  // Prepend character to reverse the word
            } else {
                // Add the reversed word and a space
                reversed = reversed + word + " ";
                word = ""; // Reset for next word
            }
        }

        // Add the last reversed word
        reversed = reversed + word;

        System.out.println(reversed);

    }
    }
