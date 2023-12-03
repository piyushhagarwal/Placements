package Stacks;

import java.util.Stack;

// 1. If the character is an operand, push it onto the stack.
// 2. If the character is an operator, pop two operands from the stack, perform the operation and push the result back.
// 3. Repeat the above steps until end of the expression.
// 4. When the expression ends, the number in the stack is the final answer.

class PostfixEvaluation {
    public static int postfixEvaluation(String expression) {
        int ans = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < expression.length(); i++) {
            // Operand is present
            if (expression.charAt(i) - '0' >= 0 && expression.charAt(i) - '0' <= 9) {
                stack.push(expression.charAt(i) - '0');
            }
            // Operator is present
            else {
                int operand2 = stack.pop();
                int operand1 = stack.pop();

                int tempAns = 0;

                switch (expression.charAt(i)) {
                    case '^':
                        tempAns = (int) Math.pow(operand1, operand2);
                        break;
                    case '*':
                        tempAns = operand1 * operand2;
                        break;
                    case '/':
                        tempAns = operand1 / operand2;
                        break;
                    case '+':
                        tempAns = operand1 + operand2;
                        break;
                    case '-':
                        tempAns = operand1 - operand2;
                        break;
                }

                stack.push(tempAns);
            }
        }

        ans = stack.pop();
        return ans;
    }

    public static void main(String[] args) {
        String expression = "46+2/5*7+";
        System.out.println(postfixEvaluation(expression));
    }
}
