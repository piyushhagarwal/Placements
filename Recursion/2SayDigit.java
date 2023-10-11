package Recursion;

class SayDigit {

    static void sayDigitRecursion(int n, String[] arr) {
        if (n == 0) {
            return;
        }

        int digit = n % 10;
        n = n / 10;

        sayDigitRecursion(n, arr);

        System.out.println(arr[digit]);
    }

    static void sayDigit(int n, String[] arr) {
        while (n > 0) {
            int digit = n % 10;
            n = n / 10;
            System.out.println(arr[digit]);
        }
    }

    public static void main(String[] args) {
        String arr[] = { "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine" };
        sayDigitRecursion(412, arr);
        sayDigit(514, arr);
    }

}