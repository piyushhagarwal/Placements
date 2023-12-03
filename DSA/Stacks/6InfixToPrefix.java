package Stacks;

import java.util.Stack;

// 1. Reverse the expression.
// 2. Change '(' to ')' and vice versa.
// 3. Convert the expression to postfix.
// 4. Reverse the answer of postfix expression to get the prefix expression.

class InfixToPrefix {
    public static String infixToPrefix(String expression) {
        String ans = "";

        // Reverse the expression
        StringBuilder stringBuilder = new StringBuilder(expression);
        stringBuilder.reverse();

        // Change '(' to ')' and vice versa
        for (int i = 0; i < stringBuilder.length(); i++) {
            if (stringBuilder.charAt(i) == '(') {
                stringBuilder.setCharAt(i, ')');
            } else if (stringBuilder.charAt(i) == ')') {
                stringBuilder.setCharAt(i, '(');
            }
        }

        expression = stringBuilder.toString();

        // Convert the expression to postfix
        ans = infixToPostfix(expression);

        // Reverse the answer of postfix expression to get the prefix expression
        ans = new StringBuilder(ans).reverse().toString();

        return ans;
    }

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

    public static void main(String[] args) {
        String expression = "A+B*(C^D-E)";
        System.out.println(infixToPrefix(expression));

    }
}
