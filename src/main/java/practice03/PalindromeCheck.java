package practice03;

public class PalindromeCheck {
    public static void main(String[] args) {
        String str = "madam";
        System.out.println("Is Palindrome? " + isPalindrome(str));

        int num = 12121;
        System.out.println("Is Palindrome? " + isPalindrome(String.valueOf(num)));
    }

    public static boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }
}
