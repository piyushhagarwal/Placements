// Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

// An input string is valid if:

// Open brackets must be closed by the same type of brackets.
// Open brackets must be closed in the correct order.
// Every close bracket has a corresponding open bracket of the same type.

// Example 1:

// Input: s = "()"
// Output: true
// Example 2:

// Input: s = "()[]{}"
// Output: true
// Example 3:

// Input: s = "(]"
// Output: false

// Link: https://leetcode.com/problems/valid-parentheses/

package Stacks;

import java.util.Stack;

class ValidParenthesis {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char character : s.toCharArray()) { // Convert string to char array and iterate over it
            if (character == '(' || character == '{' || character == '[') {
                stack.push(character);
            } else {
                if (character == ')' && !stack.isEmpty() && stack.peek() == '(') {
                    stack.pop();
                } else if (character == '}' && !stack.isEmpty() && stack.peek() == '{') {
                    stack.pop();
                } else if (character == ']' && !stack.isEmpty() && stack.peek() == '[') {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        if (stack.isEmpty()) {
            return true;
        }

        return false;

    }
}
