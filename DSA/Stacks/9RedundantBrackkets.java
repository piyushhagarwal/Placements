// Link : https://www.codingninjas.com/studio/problems/redundant-brackets_975473?leftPanelTabValue=PROBLEM
// Solution: https://www.youtube.com/watch?v=BmZnJehDzyU&list=PLDzeHZWIZsTryvtXdMr6rPh4IDexB5NIA&index=60&t=2s

package Stacks;

import java.util.Stack;

class RedundantBrackkets {
    public static boolean findRedundantBrackets(String s) {
        // Create a stack to keep track of opening brackets and operators.
        Stack<Character> stack = new Stack<>();

        // Iterate through each character in the input string.
        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);

            // If the character is an opening bracket or an operator (+, -, *, /), push it
            // onto the stack.
            if (currentChar == '(' || currentChar == '+' || currentChar == '-' || currentChar == '*'
                    || currentChar == '/') {
                stack.push(currentChar);
            } else if (currentChar == ')') {
                // Check for redundant brackets
                if (!stack.isEmpty() && stack.peek() == '(') {
                    return true; // Redundant brackets found
                }

                // Pop operators until an opening bracket is encountered
                while (!stack.isEmpty() && stack.peek() != '(') {
                    stack.pop();
                }

                // Pop the opening bracket
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            }
        }

        // If the iteration completes without finding redundant brackets.
        return false;
    }

}
