//Given a set of time intervals in any order, our task is to merge all overlapping intervals into one and output the result which should have only mutually exclusive intervals.
// Input: Intervals = {{1,3},{2,4},{6,8},{9,10}}
// Output: {{1, 4}, {6, 8}, {9, 10}}
// Explanation: Given intervals: [1,3],[2,4],[6,8],[9,10], we have only two overlapping intervals here,[1,3] and [2,4]. Therefore we will merge these two and return [1,4],[6,8], [9,10].

// Input: Intervals = {{6,8},{1,9},{2,4},{4,7}}
// Output: {{1, 9}} 

package Arrays;

import java.util.ArrayList;
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

    // Approach 2
    public int[][] merge2(int[][] intervals) {
        // Sorting

        for (int i = 0; i < intervals.length; i++) {
            for (int j = 0; j < intervals.length - i - 1; j++) {
                if (intervals[j][0] > intervals[j + 1][0]) {
                    int[] temp = intervals[j];
                    intervals[j] = intervals[j + 1];
                    intervals[j + 1] = temp;
                }
            }
        }

        int lowerBound = intervals[0][0];
        int upperBound = intervals[0][1];

        ArrayList<int[]> ans = new ArrayList<>();

        for (int i = 0; i < intervals.length; i++) {
            if (intervals[i][0] <= upperBound) {
                upperBound = Math.max(intervals[i][1], upperBound);
            } else {
                int[] subArray = new int[2];
                subArray[0] = lowerBound;
                subArray[1] = upperBound;
                ans.add(subArray);
                lowerBound = intervals[i][0];
                upperBound = intervals[i][1];

            }
        }
        int[] subArray = new int[2];
        subArray[0] = lowerBound;
        subArray[1] = upperBound;
        ans.add(subArray);

        int[][] finalAns = new int[ans.size()][];

        for (int i = 0; i < ans.size(); i++) {
            finalAns[i] = ans.get(i);
        }

        return finalAns;
    }
}