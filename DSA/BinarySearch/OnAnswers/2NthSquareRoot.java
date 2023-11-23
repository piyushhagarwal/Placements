// Problem Statement: Given two numbers N and M, find the Nth root of M. The nth root of a number M is defined as a number X when raised to the power N equals M. If the ‘nth root is not an integer, return -1.
// Solution Link : https://www.youtube.com/watch?v=rjEJeYCasHs
package BinarySearch.OnAnswers;

class NthSquareRoot {
    public static int nthSquareRootLinear(int number, int nth) {
        int ans = 0;
        for (int i = 1; i <= number; i++) {
            if ((int) Math.pow(i, nth) <= number) {
                ans = i;
            } else {
                break;
            }
        }
        return ans;
    }
    // Time complexity : O(n * log(n))
    // Math.pow() takes O(log(n)) time

    public static int nthSquareRootBinary(int number, int nth) {
        int start = 0;
        int end = number;
        int mid = start + (end - start) / 2;
        int ans = 0;

        while (start <= end) {
            if ((int) Math.pow(mid, nth) == number) {
                return mid;
            } else if ((int) Math.pow(mid, nth) < number) {
                ans = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
            mid = start + (end - start) / 2;
        }

        return ans;
    }
    // Time complexity : O(log(n) * log(n))
    // Math.pow() takes O(log(n)) time

    public static void main(String args[]) {
        int ans = nthSquareRootBinary(27, 3);
        System.out.println(ans);
    }
}
