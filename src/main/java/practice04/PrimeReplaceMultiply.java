package practice04;

import java.util.Scanner;

public class PrimeReplaceMultiply {

    // Method to check if a number is prime
    private static boolean isPrime(int n) {
        if (n <= 1) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Accept array size
        System.out.print("Enter number of elements: ");
        int size = sc.nextInt();

        int[] arr = new int[size];

        // Accept elements
        System.out.println("Enter " + size + " integers:");
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }

        // Process array
        for (int i = 0; i < size; i++) {
            if (isPrime(arr[i])) {
                arr[i] = 7; // Replace prime with 7
            } else {
                arr[i] *= 7; // Multiply non-prime by 7
            }
        }

        // Print modified array
        System.out.println("Modified array:");
        for (int num : arr) {
            System.out.print(num + " ");
        }

        sc.close();
    }
}
