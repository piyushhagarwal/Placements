// Link : https://www.codingninjas.com/studio/problems/minimum-cost-to-make-string-valid_1115770?leftPanelTab=0%3Fsource%3Dyoutube&campaign=Lovebabbarcodestudio&utm_source=youtube&utm_medium=affiliate&utm_campaign=Lovebabbarcodestudio&leftPanelTabValue=PROBLEM?
// Solution: https://www.youtube.com/watch?v=BmZnJehDzyU&list=PLDzeHZWIZsTryvtXdMr6rPh4IDexB5NIA&index=60
package Stacks;

class MinReversal {
    public static int findMinimumCost(String str) {
        // Step 1: Remove redundant brackets using a stack
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '{') {
                stack.push(str.charAt(i));
            } else {
                if (!stack.isEmpty() && stack.peek() == '{') {
                    stack.pop();
                } else {
                    stack.push(str.charAt(i));
                }
            }
        }

        // Create a StringBuilder to store the string containing only redundant brackets
        StringBuilder wrongString = new StringBuilder();
        while (!stack.isEmpty()) {
            wrongString.append(stack.pop());
        }

        // Count the number of open and close brackets in the wrongString
        int openBracketCount = 0;
        int closeBracketCount = 0;

        for (int i = 0; i < wrongString.length(); i++) {
            if (wrongString.charAt(i) == '{') {
                openBracketCount++;
            } else {
                closeBracketCount++;
            }
        }

        // Check if the total number of brackets is odd, return -1 if so
        if ((openBracketCount + closeBracketCount) % 2 == 1) {
            return -1;
        }

        // Calculate the minimum cost based on the number of open and close brackets
        int ans = ((openBracketCount + 1) / 2) + ((closeBracketCount + 1) / 2);
        return ans;
    }

}
