// You have planned some train traveling one year in advance. The days of the year in which you will travel are given as an integer array days. Each day is an integer from 1 to 365.

// Train tickets are sold in three different ways:

// a 1-day pass is sold for costs[0] dollars,
// a 7-day pass is sold for costs[1] dollars, and
// a 30-day pass is sold for costs[2] dollars.
// The passes allow that many days of consecutive travel.

// For example, if we get a 7-day pass on day 2, then we can travel for 7 days: 2, 3, 4, 5, 6, 7, and 8.
// Return the minimum number of dollars you need to travel every day in the given list of days.

// Example 1:

// Input: days = [1,4,6,7,8,20], costs = [2,7,15]
// Output: 11
// Explanation: For example, here is one way to buy passes that lets you travel your travel plan:
// On day 1, you bought a 1-day pass for costs[0] = $2, which covered day 1.
// On day 3, you bought a 7-day pass for costs[1] = $7, which covered days 3, 4, ..., 9.
// On day 20, you bought a 1-day pass for costs[0] = $2, which covered day 20.
// In total, you spent $11 and covered all the days of your travel.
// Example 2:

// Input: days = [1,2,3,4,5,6,7,8,9,10,30,31], costs = [2,7,15]
// Output: 17
// Explanation: For example, here is one way to buy passes that lets you travel your travel plan:
// On day 1, you bought a 30-day pass for costs[2] = $15 which covered days 1, 2, ..., 30.
// On day 31, you bought a 1-day pass for costs[0] = $2 which covered day 31.
// In total, you spent $17 and covered all the days of your travel.

// Link: https://leetcode.com/problems/minimum-cost-for-tickets/
// Solution: https://www.youtube.com/watch?v=oZ_xAIGCXw4&list=PLDzeHZWIZsTomOPnCiU3J95WufjE36wsb&index=13

package DynamicProgramming.OneDimention;

class MinCostTickets {
    public int Recur(int[] days, int index, int[] costs) {
        // Base Case
        if (index >= days.length) {
            return 0;
        }

        int option1 = costs[0] + Recur(days, index + 1, costs);

        int start1 = index;
        int validTill1 = days[index] + 6;
        for (int i = index; i < days.length; i++) {
            if (days[i] <= validTill1) {
                start1++;
            }
        }
        int option2 = costs[1] + Recur(days, start1, costs);

        int start2 = index;
        int validTill2 = days[index] + 29;
        for (int i = index; i < days.length; i++) {
            if (days[i] <= validTill2) {
                start2++;
            }
        }
        int option3 = costs[2] + Recur(days, start2, costs);

        int ans = Math.min(option1, Math.min(option2, option3));
        return ans;
    }

    public int RecurMem(int[] days, int index, int[] costs, int[] dp) {
        // Base Case
        if (index >= days.length) {
            return 0;
        }

        if (dp[index] != -1) {
            return dp[index];

        }

        int option1 = costs[0] + RecurMem(days, index + 1, costs, dp);

        int start1 = index;
        int validTill1 = days[index] + 6;
        for (int i = index; i < days.length; i++) {
            if (days[i] <= validTill1) {
                start1++;
            }
        }
        int option2 = costs[1] + RecurMem(days, start1, costs, dp);

        int start2 = index;
        int validTill2 = days[index] + 29;
        for (int i = index; i < days.length; i++) {
            if (days[i] <= validTill2) {
                start2++;
            }
        }
        int option3 = costs[2] + RecurMem(days, start2, costs, dp);

        dp[index] = Math.min(option1, Math.min(option2, option3));
        return dp[index];
    }

    public int mincostTickets(int[] days, int[] costs) {
        // int index = 0;
        // return Recur(days,index, costs);

        int dp[] = new int[days.length + 1];
        for (int i = 0; i <= days.length; i++) {
            dp[i] = -1;
        }
        return RecurMem(days, 0, costs, dp);
    }
}
