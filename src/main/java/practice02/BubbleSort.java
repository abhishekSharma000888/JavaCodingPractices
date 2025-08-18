package practice02;

import java.util.Arrays;

public class BubbleSort {

    public static void main(String[] args) {
        int[] input = {1, 3, 2, 7, 5, 9, 0, 11, 9, 32, -11};

        // Bubble Sort
        for (int i = 0; i < input.length - 1; i++) {
            for (int j = 0; j < input.length - i - 1; j++) {
                if (input[j] > input[j + 1]) {
                    // Swap elements
                    int temp = input[j];
                    input[j] = input[j + 1];
                    input[j + 1] = temp;
                }
            }
        }

        // Print sorted array
        System.out.println("Sorted Array: " + Arrays.toString(input));
    }
}
