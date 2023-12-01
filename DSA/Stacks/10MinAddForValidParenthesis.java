// A parentheses string is valid if and only if:

// It is the empty string,
// It can be written as AB (A concatenated with B), where A and B are valid strings, or
// It can be written as (A), where A is a valid string.
// You are given a parentheses string s. In one move, you can insert a parenthesis at any position of the string.

// For example, if s = "()))", you can insert an opening parenthesis to be "(()))" or a closing parenthesis to be "())))".
// Return the minimum number of moves required to make s valid.

// Example 1:

// Input: s = "())"
// Output: 1
// Example 2:

// Input: s = "((("
// Output: 3

// Link: https://leetcode.com/problems/minimum-add-to-make-parentheses-valid/

package Stacks;

import java.util.Stack;

class MinAddForValidParenthesis {
    public int minAddToMakeValid(String s) {
        // Create a stack to keep track of opening parentheses.
        Stack<Character> stack = new Stack<>();

        // Iterate through each character in the input string.
        for (int i = 0; i < s.length(); i++) {
            // If the current character is an opening parenthesis, push it onto the stack.
            if (s.charAt(i) == '(') {
                stack.push('(');
            } else {
                // If the current character is a closing parenthesis:
                if (!stack.isEmpty() && stack.peek() == '(') {
                    // If there is a matching opening parenthesis on the stack, pop it.
                    stack.pop();
                } else {
                    // If there is no matching opening parenthesis, push the closing parenthesis
                    // onto the stack.
                    stack.push(')');
                }
            }
        }

        // The remaining elements in the stack represent unmatched parentheses.
        // The size of the stack is the minimum number of parentheses needed to make the
        // string valid.
        return stack.size();
    }

}
