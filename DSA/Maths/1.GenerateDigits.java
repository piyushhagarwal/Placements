package Maths;

// Given number n, give all the digits from the number n.

class GenerateDigits {
    public static void generateDigits(int n) {
        while (n > 0) {
            int digit = n % 10; // get the last digit
            System.out.println(digit);
            n = n / 10; // remove the last digit
        }
    }

    public static void main(String[] args) {
        int n = 12345;
        generateDigits(n);
    }
}
