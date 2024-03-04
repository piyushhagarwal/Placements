// Given weights and values of N items, we need to put these items in a knapsack of capacity W to get the maximum total value in the knapsack.
// Note: Unlike 0/1 knapsack, you are allowed to break the item here. 

// Example 1:

// Input:
// N = 3, W = 50
// value[] = {60,100,120}
// weight[] = {10,20,30}
// Output:
// 240.000000
// Explanation:
// Take the item with value 60 and weight 10, value 100 and weight 20 and split the third item with value 120 and weight 30, to fit it into weight 20. so it becomes (120/30)*20=80, so the total value becomes 60+100+80.0=240.0
// Thus, total maximum value of item we can have is 240.00 from the given capacity of sack. 
// Example 2:

// Input:
// N = 2, W = 50
// value[] = {60,100}
// weight[] = {10,20}
// Output:
// 160.000000
// Explanation:
// Take both the items completely, without breaking.
// Total maximum value of item we can have is 160.00 from the given capacity of sack.
// Your Task :
// Complete the function fractionalKnapsack() that receives maximum capacity , array of structure/class and size N and returns a double value representing the maximum value in knapsack.
// Note: The details of structure/class is defined in the comments above the given function.

// Expected Time Complexity : O(NlogN)
// Expected Auxilliary Space: O(1)

// Link: https://practice.geeksforgeeks.org/problems/fractional-knapsack-1587115620/1
// Solution: https://takeuforward.org/data-structure/fractional-knapsack-problem-greedy-approach/

package GreedyAlgos;

import java.util.Arrays;
import java.util.Comparator;

class Item {
    int value, weight;

    Item(int x, int y) {
        this.value = x;
        this.weight = y;
    }
}

class Solution {
    // Function to get the maximum total value in the knapsack.
    double fractionalKnapsack(int W, Item arr[], int n) {
        // Your code here
        double ans = 0;
        Arrays.sort(arr, new Comparator<Item>() {
            @Override
            public int compare(Item a, Item b) {
                return Double.compare((double) b.value / b.weight, (double) a.value / a.weight);
            }
        });
        for (int i = 0; i < n; i++) {
            if (arr[i].weight <= W) {
                ans += arr[i].value;
                W -= arr[i].weight;
            } else {
                if (W > 0) {
                    ans += (((double) arr[i].value / (double) arr[i].weight) * (double) W);
                    W = 0;
                } else {
                    break;
                }
            }
        }
        return ans;
    }
}
