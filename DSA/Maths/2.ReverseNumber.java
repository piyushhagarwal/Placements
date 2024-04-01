package Maths;

// Given a number n, reverse the number.

class ReverseNumber {
    public static int reverseNumber(int n) {
        int reversedNumber = 0;
        while (n > 0) {
            int digit = n % 10; // get the last digit
            reversedNumber = reversedNumber * 10 + digit;
            n = n / 10; // remove the last digit
        }
        return reversedNumber;
    }

    public static void main(String[] args) {
        int n = 12345;
        System.out.println(reverseNumber(n));
    }
}
