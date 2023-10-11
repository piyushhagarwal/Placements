package Recursion;

class Palindrome {
    public static boolean checkPalindrome(String str, int start, int end) {
        if (start >= end) {
            return true;
        }
        if (str.charAt(start) == str.charAt(end)) {
            return checkPalindrome(str, start + 1, end - 1);
        } else {
            return false;
        }
    }

    public static void main(String args[]) {
        String str = "abba";
        System.out.println(checkPalindrome(str, 0, str.length() - 1));
    }
}
