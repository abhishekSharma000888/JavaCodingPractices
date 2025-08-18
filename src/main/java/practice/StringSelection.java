package practice;

public class StringSelection {

    // Input = aabbcccaabbb
    //  Output = abcab
    // abc
    public static void main(String[] args) {
        // Input = aabbcccaabbb
        //  Output = abcab
        // abc

        String input = "d";

        StringBuilder output = new StringBuilder();

        output.append(input.charAt(0));

        for (int i = 0; i < input.length(); i++) {

            char current = input.charAt(i);

            if (output.indexOf(String.valueOf(current)) == -1) {
                output.append(current);
            }
        }

        System.out.println("The output is: " + output);
    }
}
