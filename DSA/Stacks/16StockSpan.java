// Design an algorithm that collects daily price quotes for some stock and returns the span of that stock's price for the current day.

// The span of the stock's price in one day is the maximum number of consecutive days (starting from that day and going backward) for which the stock price was less than or equal to the price of that day.

// For example, if the prices of the stock in the last four days is [7,2,1,2] and the price of the stock today is 2, then the span of today is 4 because starting from today, the price of the stock was less than or equal 2 for 4 consecutive days.
// Also, if the prices of the stock in the last four days is [7,34,1,2] and the price of the stock today is 8, then the span of today is 3 because starting from today, the price of the stock was less than or equal 8 for 3 consecutive days.
// Implement the StockSpanner class:

// StockSpanner() Initializes the object of the class.
// int next(int price) Returns the span of the stock's price given that today's price is price.

// Example 1:

// Input
// ["StockSpanner", "next", "next", "next", "next", "next", "next", "next"]
// [[], [100], [80], [60], [70], [60], [75], [85]]
// Output
// [null, 1, 1, 1, 2, 1, 4, 6]

// Explanation
// StockSpanner stockSpanner = new StockSpanner();
// stockSpanner.next(100); // return 1
// stockSpanner.next(80);  // return 1
// stockSpanner.next(60);  // return 1
// stockSpanner.next(70);  // return 2
// stockSpanner.next(60);  // return 1
// stockSpanner.next(75);  // return 4, because the last 4 prices (including today's price of 75) were less than or equal to today's price.
// stockSpanner.next(85);  // return 6

// Link : https://leetcode.com/problems/online-stock-span/

package Stacks;

import java.util.ArrayList;
import java.util.Stack;

// Naive approach
class StockSpanner {

    ArrayList<Integer> arrayList;

    // Constructor to initialize the ArrayList
    public StockSpanner() {
        arrayList = new ArrayList<>();
    }

    // Method to calculate the span of the stock price for the next day
    public int next(int price) {
        // Step 1: Add the current price to the ArrayList
        arrayList.add(price);

        // Step 2: Create a stack and push all prices from the ArrayList onto the stack
        Stack<Integer> stack = new Stack<>();
        for (int num : arrayList) {
            stack.push(num);
        }

        // Step 3: Initialize a count to track the span
        int count = 0;

        // Step 4: Pop elements from the stack while they are less than or equal to the
        // current price
        while (!stack.isEmpty() && stack.peek() <= price) {
            count++;
            stack.pop();
        }

        // Step 5: Return the calculated span for the current day
        return count;
    }
}

// Optimized approach
class StockSpanner1 {
    // Step 1: Declare a stack to store pairs of prices and spans
    Stack<ArrayList<Integer>> stack;

    // Step 2: Constructor to initialize the stack
    public StockSpanner1() {
        stack = new Stack<>();
    }

    // Step 3: Method to calculate the span of the stock price for the next day
    public int next(int price) {
        // Step 4: Initialize the span for the current day to 1
        int span = 1;

        // Step 5: Pop elements from the stack whose prices are less than or equal to
        // the current price
        while (!stack.isEmpty() && stack.peek().get(0) <= price) {
            span += stack.pop().get(1);
        }

        // Step 6: Create an ArrayList to store the current price and its corresponding
        // span
        ArrayList<Integer> temp = new ArrayList();
        temp.add(price);
        temp.add(span);

        // Step 7: Push the current price and its span onto the stack
        stack.push(temp);

        // Step 8: Return the calculated span for the current day
        return span;
    }
}
