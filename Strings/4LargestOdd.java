// You are given a string num, representing a large integer.
//Return the largest-valued odd integer (as a string) that is a non-empty substring of num, or an empty string "" if no odd integer exists.

// A substring is a contiguous sequence of characters within a string.

// Example 1:

// Input: num = "52"
// Output: "5"
// Explanation: The only non-empty substrings are "5", "2", and "52". "5" is the only odd number.
// Example 2:

// Input: num = "4206"
// Output: ""
// Explanation: There are no odd numbers in "4206".
// Example 3:

// Input: num = "35427"
// Output: "35427"
// Explanation: "35427" is already an odd number.

package Strings;

class LargestOddNumber {
    public static String largestOddNumber(String num) {
        String ans = "";
        int ind = -1;

        // Find the index from the last for the odd
        for (int i = num.length() - 1; i >= 0; i--) {
            if ((num.charAt(i) - '0') % 2 != 0) { // Dont forget to put braketts before %
                ind = i;
                break;
            }
        }

        // if index found then add all digits till that index.
        if (ind != -1) {
            for (int i = 0; i <= ind; i++) {
                ans += num.charAt(i);
            }
        }

        return ans;
    }

    // Q. How to convert a Character to integer?
    // Ans: 'character' - '0' (Eg: '5' - '0')

    // Q. How to convert a string to integer?
    // Ans: Integer.parseInt(str)

    // Q. How to get a substring from a string?
    // String originalString = "Hello, World!";
    // String substring = originalString.substring(7, 12);
    // Starts from index 7 and ends at index 11(Last index is exclusive)

    // Q. How to convert a integer to string?
    // Integer.toString(number);

    public static void main(String[] args) {
        System.out.println(largestOddNumber("7542351161"));
    }
}