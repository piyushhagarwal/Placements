package Stacks;

import java.util.Stack;

class PrefixEvaluation {
    public static int prefixEvaluation(String expression) {
        int ans = 0;
        Stack<Integer> stack = new Stack<>();

        // Start from the end of the expression
        for (int i = expression.length() - 1; i >= 0; i--) {
            // Operand is present
            if (expression.charAt(i) - '0' >= 0 && expression.charAt(i) - '0' <= 9) {
                stack.push(expression.charAt(i) - '0');
            }
            // Operator is present
            else {
                int operand1 = stack.pop();
                int operand2 = stack.pop();

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
        String expression = "+9*26";
        System.out.println(prefixEvaluation(expression));
    }
}
