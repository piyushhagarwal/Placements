// Given an input string s, reverse the order of the words.

// A word is defined as a sequence of non-space characters. The words in s will be separated by at least one space.

// Return a string of the words in reverse order concatenated by a single space.

// Note that s may contain leading or trailing spaces or multiple spaces between two words. The returned string should only have a single space separating the words. 
// Do not include any extra spaces.

// Example 1:

// Input: s = "the sky is blue"
// Output: "blue is sky the"
// Example 2:

// Input: s = "  hello world  "
// Output: "world hello"
// Explanation: Your reversed string should not contain leading or trailing spaces.
// Example 3:

// Input: s = "a good   example"
// Output: "example good a"
// Explanation: You need to reduce multiple spaces between two words to a single space in the reversed string.

package Strings;

import java.util.Stack;

class ReverseWords {

    public static String reverseWords(String s) {
        Stack<String> stack = new Stack<>();
        StringBuffer ans = new StringBuffer("");
        StringBuffer word = new StringBuffer("");

        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) != ' ') {
                word.append(s.charAt(i));
            } else {
                if (word.isEmpty()) {
                    continue;
                } else if (s.charAt(i - 1) != ' ') {
                    stack.push(word.toString());
                    word.setLength(0);
                }
            }
        }
        if (!word.isEmpty()) {
            stack.push(word.toString());
        }

        while (!stack.isEmpty()) {
            ans.append(stack.pop());
            if (!stack.isEmpty()) {
                ans.append(" ");
            }

        }

        return ans.toString();
    }
}
