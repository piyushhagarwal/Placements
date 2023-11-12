// Given two strings s and goal, return true if and only if s can become goal after some number of shifts on s.

// A shift on s consists of moving the leftmost character of s to the rightmost position.

// For example, if s = "abcde", then it will be "bcdea" after one shift.

// Example 1:

// Input: s = "abcde", goal = "cdeab"
// Output: true
// Example 2:

// Input: s = "abcde", goal = "abced"
// Output: false

package Strings;

class RotateString {
    public boolean rotateString(String s, String goal) {

        if (s.length() != goal.length()) {
            return false;
        }
        StringBuffer ans = new StringBuffer(s);
        for (int i = 0; i < s.length(); i++) {
            ans.append(s.charAt(i));
            if (ans.substring(i + 1).equals(goal)) {
                return true;
            }
        }
        return false;
    }

    // In java we cant directly compare strings by using ==
    // therfore we use .equals()
}
