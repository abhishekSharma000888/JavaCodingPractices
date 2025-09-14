package practice03;

public class ReverseWords {
    public static void main(String[] args) {
        String input = "SDET role in Java";
        String[] words = input.trim().split("\\s+");

        StringBuilder reversed = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            reversed.append(words[i]).append(" ");
        }
        System.out.println("Reversed: " + reversed.toString().trim());
    }
}
