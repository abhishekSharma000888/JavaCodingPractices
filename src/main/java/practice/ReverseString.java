package practice;

public class ReverseString {

    public static void main(String[] args) {

        String input = "India is great";
        // output = Great is India


        String[] words = input.split(" ");
        StringBuilder result = new StringBuilder();

        for(int i= words.length-1; i>=0; i--){

            result.append(words[i]);
            result.append(" ");
        }

        String output = result.toString().trim();
        output = output.substring(0,1).toUpperCase()+ output.substring(1);


        System.out.println(output);

    }
}
