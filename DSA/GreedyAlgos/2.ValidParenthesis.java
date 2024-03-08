// Given a string s containing only three types of characters: '(', ')' and '*', return true if s is valid.

// The following rules define a valid string:

// Any left parenthesis '(' must have a corresponding right parenthesis ')'.
// Any right parenthesis ')' must have a corresponding left parenthesis '('.
// Left parenthesis '(' must go before the corresponding right parenthesis ')'.
// '*' could be treated as a single right parenthesis ')' or a single left parenthesis '(' or an empty string "".

// Example 1:

// Input: s = "()"
// Output: true
// Example 2:

// Input: s = "(*)"
// Output: true
// Example 3:

// Input: s = "(*))"
// Output: true

// Link : https://leetcode.com/problems/valid-parenthesis-string/

package GreedyAlgos;

// The approach is to record the index of either left bracket or star character in separate stacks, and then when encountering a right bracket, attempt to match it with a corresponding left bracket, star, or failing that, to return false.

// Once the string has been fully evaluated in the for loop, remaining elements in both stacks are evaluated against each other.

// If the index of the left bracket is less than that of the star, they can be matched together and eliminated.

// Finally, if there are any remaining elements in the left bracket stack, we can surmise there were insufficient stars to neutralize all remaining left brackets.

// If there are no remaining elements, the stars and left brackets were evenly matched.

import java.util.Stack;

class ValidStringChecker {
    public boolean checkValidString(String inputString) {
        // Stacks to keep track of indices for '(' and '*'
        Stack<Integer> leftParenthesisStack = new Stack<>();
        Stack<Integer> asteriskStack = new Stack<>();

        // Iterate through the characters in the input string
        for (int i = 0; i < inputString.length(); i++) {
            char currentChar = inputString.charAt(i);

            // If the current character is '(', push its index onto the left parenthesis
            // stack
            if (currentChar == '(') {
                leftParenthesisStack.push(i);
            }
            // If the current character is '*', push its index onto the asterisk stack
            else if (currentChar == '*') {
                asteriskStack.push(i);
            }
            // If the current character is ')'
            else {
                // If both stacks are empty, there is no matching '(' or '*' for the current ')'
                if (leftParenthesisStack.isEmpty() && asteriskStack.isEmpty()) {
                    return false;
                }
                // If there is a '(' on the left parenthesis stack, pop it
                else if (!leftParenthesisStack.isEmpty()) {
                    leftParenthesisStack.pop();
                }
                // If there is no '(' on the left parenthesis stack, pop an '*' from the
                // asterisk stack
                else {
                    asteriskStack.pop();
                }
            }
        }

        // Process the remaining '(' and '*' after iterating through the input string
        while (!leftParenthesisStack.isEmpty() && !asteriskStack.isEmpty()
                && asteriskStack.peek() > leftParenthesisStack.peek()) {
            leftParenthesisStack.pop();
            asteriskStack.pop();
        }

        // If the left parenthesis stack is empty, the string is valid
        return leftParenthesisStack.isEmpty();
    }
}
