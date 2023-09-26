//Given a set of time intervals in any order, our task is to merge all overlapping intervals into one and output the result which should have only mutually exclusive intervals.
// Input: Intervals = {{1,3},{2,4},{6,8},{9,10}}
// Output: {{1, 4}, {6, 8}, {9, 10}}
// Explanation: Given intervals: [1,3],[2,4],[6,8],[9,10], we have only two overlapping intervals here,[1,3] and [2,4]. Therefore we will merge these two and return [1,4],[6,8], [9,10].

// Input: Intervals = {{6,8},{1,9},{2,4},{4,7}}
// Output: {{1, 9}} 

package Arrays;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

class Solution {
    public int[][] merge(int[][] intervals) {

        Arrays.sort(intervals, Comparator.comparingInt(ele -> ele[0]));

        Stack<int[]> stack = new Stack<>();
        stack.push(intervals[0]);

        for (int i = 1; i < intervals.length; i++) {

            int[] top = stack.peek();

            // if current interval is not overlapping with
            // stack top, push it to the stack
            if (top[1] < intervals[i][0]) {
                stack.push(intervals[i]);
            }

            // Otherwise update the ending time of top if
            // ending of current interval is more
            else if (top[1] >= intervals[i][0]) {
                top[1] = Math.max(top[1], intervals[i][1]);
                stack.pop();
                stack.push(top);
            }
        }

        int[][] ans = new int[stack.size()][2];

        int i = 0;
        while (!stack.isEmpty()) {
            int top[] = stack.peek();
            ans[i] = top;
            stack.pop();
            i++;
        }

        return ans;
    }
}