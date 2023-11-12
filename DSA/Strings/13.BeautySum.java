// The beauty of a string is the difference in frequencies between the most frequent and least frequent characters.

// For example, the beauty of "abaacc" is 3 - 1 = 2.
// Given a string s, return the sum of beauty of all of its substrings.

// Example 1:

// Input: s = "aabcb"
// Output: 5
// Explanation: The substrings with non-zero beauty are ["aab","aabc","aabcb","abcb","bcb"], each with beauty equal to 1.
// Example 2:

// Input: s = "aabcbaa"
// Output: 17

package Strings;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;

class Solution {
    public static int helper(HashMap<Character, Integer> subStr) {
        Collection<Integer> allValues = subStr.values();
        int maxValue = Collections.max(allValues);
        int minValue = Collections.min(allValues);
        return maxValue - minValue;
    }

    public int beautySum(String s) {
        int sum = 0;
        int n = s.length();
        if (n < 1) {
            return 0;
        }
        for (int i = 0; i < n; i++) {
            HashMap<Character, Integer> subStr = new HashMap<>();
            for (int j = i; j < n; j++) {
                subStr.put(s.charAt(j), subStr.getOrDefault(s.charAt(j), 0) + 1);
                sum += helper(subStr);
            }
        }
        return sum;
    }
}
