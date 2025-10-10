package practice04;


public class SlidingWindowExample {

    // Function to find the maximum sum of a subarray of size k
    public static int maxSumSubarray(int[] arr, int k) {
        int n = arr.length;
        if (n < k) {
            System.out.println("Array length is smaller than subarray size.");
            return -1;
        }

        // Compute sum of first window of size k
        int maxSum = 0;
        for (int i = 0; i < k; i++) {
            maxSum += arr[i];
        }

        int windowSum = maxSum;
        // Slide the window from start to end
        for (int i = k; i < n; i++) {
            windowSum += arr[i] - arr[i - k]; // Add next element, remove first element of previous window
            maxSum = Math.max(maxSum, windowSum);
        }

        return maxSum;
    }

    public static void main(String[] args) {
        int[] arr = {2, 1, 5, 1, 3, 2};
        int k = 3;
        int result = maxSumSubarray(arr, k);
        System.out.println("Maximum sum of subarray of size " + k + " is " + result);
    }
}
