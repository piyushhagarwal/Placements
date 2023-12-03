package Stacks;

import java.util.Stack;

// Initialize an empty string (ans) and a stack (stack).
// Iterate through each character in the infix expression:
//      1. If the character is '(', push it onto the stack.
//      2. If the character is ')', pop and append operators from the stack to ans until '(' is encountered. Pop '(' from the stack.
//      3. If the character is an operator (^, *, /, +, -), handle the precedence and push or pop operators accordingly.
//         - If the character is of lower precedence than the operator at the top of the stack, pop and append the operator from the stack to ans.
//         - Else, push the character onto the stack.
//      4. If the character is an operand, append it to ans.
// After processing all characters, pop and append any remaining operators from the stack to ans.
// Return the final postfix expression (ans).

class InfixToPostfix {

    // Function to give preference/priority of the operator ('^' > '*' / '/' > '+' /
    // '-')
    public static int preference(char operator) {
        switch (operator) {
            case '^':
                return 1;
            case '*':
                return 2;
            case '/':
                return 2;
            case '+':
                return 3;
            case '-':
                return 3;
            default:
                break;
        }
        return -1;
    }

    public static String infixToPostfix(String expression) {
        String ans = "";
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < expression.length(); i++) {
            char character = expression.charAt(i);

            if (character == '(') {
                stack.push(character);
            }

            else if (character == ')') {
                while (stack.peek() != '(') {
                    ans += stack.pop();
                }
                stack.pop(); // To remove '(' from the stack
            }

            else if (character == '^' || character == '*' || character == '/' || character == '+' || character == '-') {
                if (!stack.isEmpty() && (stack.peek() == '(' || preference(character) < preference(stack.peek()))) {
                    stack.push(character);
                } else {
                    while (!stack.isEmpty() && stack.peek() != '('
                            && preference(stack.peek()) <= preference(character)) {
                        ans += stack.pop();
                    }
                    stack.push(character);
                }
            }

            // If the character is Operand
            else {
                ans += character;
            }

        }

        while (!stack.isEmpty()) {
            ans += stack.pop();
        }

        return ans;
    }

    public static void main(String args[]) {
        // Testcases
        String expression = "a+b*(c^d-e)^(f+g*h)-i";
        System.out.println(infixToPostfix(expression)); // abcd^e-fgh*+^*+i-

        expression = "a+b*c";
        System.out.println(infixToPostfix(expression)); // abc*+

        expression = "a+b*c^d-e";
        System.out.println(infixToPostfix(expression)); // abcd^*+e-

        expression = "A+B*(C^D-E)";
        System.out.println(infixToPostfix(expression)); // abcd^*+ef^-
    }

}
