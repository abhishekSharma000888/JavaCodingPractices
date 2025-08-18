package practice02;

public class ReverseAString {

    public static void main(String[] args) {

        String input = "reverse this string! a";
        char[] inputArr = input.toCharArray();
        char[] result = new char[inputArr.length];

        //first save spaces

        for(int i=0; i<inputArr.length; i++){

            if(inputArr[i] == ' '){

                result[i] = ' ';
            }
        }

        int j = inputArr.length -1;

        for(int i=0; i<inputArr.length; i++){

            if(result[i] != ' '){

                while(j == ' '){
                    j--;
                }
                result[i] = inputArr[j];
                j--;
            }


        }
        System.out.println(new String(result));
    }
}
