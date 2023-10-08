// Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.

// Symbol       Value
// I             1
// V             5
// X             10
// L             50
// C             100
// D             500
// M             1000
// For example, 2 is written as II in Roman numeral, just two ones added together. 12 is written as XII, which is simply X + II. The number 27 is written as XXVII, which is XX + V + II.

// Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:

// I can be placed before V (5) and X (10) to make 4 and 9. 
// X can be placed before L (50) and C (100) to make 40 and 90. 
// C can be placed before D (500) and M (1000) to make 400 and 900.
// Given a roman numeral, convert it to an integer.

// Example 1:

// Input: s = "III"
// Output: 3
// Explanation: III = 3.
// Example 2:

// Input: s = "LVIII"
// Output: 58
// Explanation: L = 50, V= 5, III = 3.
// Example 3:

// Input: s = "MCMXCIV"
// Output: 1994
// Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.

package Strings;

import java.util.HashMap;
import java.util.Map;

class RomanToInt {
    public int romanToInt(String s) {

        // Initialize the result
        int ans = 0;

        // Create a map to store the values of Roman numerals
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        // Variable to store the subtraction value for cases like IV, IX, XL, XC, etc.
        int subValue = 0;

        // Iterate through the Roman numeral string
        for (int i = 0; i < s.length() - 1; i++) {
            // Get the current and next characters
            char key = s.charAt(i);

            // Compare the values of the current and next characters
            if (map.get(key) >= map.get(s.charAt(i + 1))) {
                // If the current value is greater than or equal to the next value, add the
                // current value
                int currentValue = map.get(key) - subValue;
                ans += currentValue;

                // Reset the subtraction value
                subValue = 0;
            } else {
                // If the current value is less than the next value, set the subtraction value
                subValue = map.get(key);
            }
        }

        // Process the last character of the Roman numeral string
        int currentValue = map.get(s.charAt(s.length() - 1)) - subValue;
        ans += currentValue;

        // Return the final result
        return ans;
    }
}
