package week1_practice;

public class PalindromeChecker {

    // Iterative method
    static boolean isPalindromeIterative(String text) {

        int start = 0;
        int end = text.length() - 1;

        while (start < end) {

            if (text.charAt(start) != text.charAt(end)) {
                return false;
            }

            start++;
            end--;
        }

        return true;
    }

    // Recursive method
    static boolean isPalindromeRecursive(String text) {

        if (text.length() <= 1) {
            return true;
        }

        if (text.charAt(0) != text.charAt(text.length() - 1)) {
            return false;
        }

        return isPalindromeRecursive(
                text.substring(1, text.length() - 1)
        );
    }

    // Array reversal method
    static boolean isPalindromeArrayReversal(String text) {

        char[] arr = text.toCharArray();

        int start = 0;
        int end = arr.length - 1;

        while (start < end) {

            char temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;

            start++;
            end--;
        }

        String reversed = new String(arr);

        return text.equals(reversed);
    }

    public static void main(String[] args) {

        String text = "madam";

        if (isPalindromeIterative(text)) {
            System.out.println("Iterative: Palindrome");
        }
        else {
            System.out.println("Iterative: Not Palindrome");
        }

        if (isPalindromeRecursive(text)) {
            System.out.println("Recursive: Palindrome");
        }
        else {
            System.out.println("Recursive: Not Palindrome");
        }

        if (isPalindromeArrayReversal(text)) {
            System.out.println("Array Reversal: Palindrome");
        }
        else {
            System.out.println("Array Reversal: Not Palindrome");
        }
    }
}