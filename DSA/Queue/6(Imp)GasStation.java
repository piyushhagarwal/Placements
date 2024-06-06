// There are n gas stations along a circular route, where the amount of gas at the ith station is gas[i].

// You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from the ith station to its next (i + 1)th station. You begin the journey with an empty tank at one of the gas stations.

// Given two integer arrays gas and cost, return the starting gas station's index if you can travel around the circuit once in the clockwise direction, otherwise return -1. If there exists a solution, it is guaranteed to be unique

// Example 1:

// Input: gas = [1,2,3,4,5], cost = [3,4,5,1,2]
// Output: 3
// Explanation:
// Start at station 3 (index 3) and fill up with 4 unit of gas. Your tank = 0 + 4 = 4
// Travel to station 4. Your tank = 4 - 1 + 5 = 8
// Travel to station 0. Your tank = 8 - 2 + 1 = 7
// Travel to station 1. Your tank = 7 - 3 + 2 = 6
// Travel to station 2. Your tank = 6 - 4 + 3 = 5
// Travel to station 3. The cost is 5. Your gas is just enough to travel back to station 3.
// Therefore, return 3 as the starting index.
// Example 2:

// Input: gas = [2,3,4], cost = [3,4,3]
// Output: -1
// Explanation:
// You can't start at station 0 or 1, as there is not enough gas to travel to the next station.
// Let's start at station 2 and fill up with 4 unit of gas. Your tank = 0 + 4 = 4
// Travel to station 0. Your tank = 4 - 3 + 2 = 3
// Travel to station 1. Your tank = 3 - 3 + 3 = 3
// You cannot travel back to station 2, as it requires 4 unit of gas but you only have 3.
// Therefore, you can't travel around the circuit once no matter where you start.

// Link : https://leetcode.com/problems/gas-station/
// Solution : https://www.youtube.com/watch?v=_gJ3to4RyeQ&list=PLDzeHZWIZsTryvtXdMr6rPh4IDexB5NIA&index=66&t=2223s

package Queue;

class GasStation {
    // Naive approach
    public int canCompleteCircuit(int[] gas, int[] cost) {
        // Iterate through each gas station as a potential starting point
        for (int i = 0; i < gas.length; i++) {
            // Calculate the balance (gas - cost) at the current station
            int balance = gas[i] - cost[i];

            // If the balance is negative, this station cannot be a starting point
            if (balance < 0) {
                continue;
            }

            // Try to complete the circuit starting from the current station
            int j = (i + 1) % gas.length;
            while (j != i) {
                // Update the balance as you move to the next station
                balance = balance + gas[j] - cost[j];

                // If the balance becomes negative, break the loop as this station is not valid
                if (balance < 0) {
                    break;
                }

                // Move to the next station in a circular manner
                j = (j + 1) % gas.length;
            }

            // If the balance is still non-negative, return the current station as the
            // starting point
            if (balance >= 0) {
                return i;
            }
        }

        // If no valid starting point is found, return -1
        return -1;
    }

    // Efficient approach
    public int canCompleteCircuit1(int[] gas, int[] cost) {
        int balance = 0; // Keeps track of the current balance (gas - cost)
        int front = 0; // Represents the potential starting point
        int rear = 0; // Represents the current station being checked

        while (front < gas.length) {
            // Update the balance with the gas and cost of the current station
            balance = balance + gas[rear] - cost[rear];

            // If the balance is non-negative, move to the next station
            if (balance >= 0) {
                rear = (rear + 1) % gas.length;

                // If rear wraps around to front, a valid circuit is found
                if (rear == front) {
                    return front;
                }
            }
            // If the balance becomes negative, reset balance and move front to the next
            // station
            else {
                balance = 0;
                int nextFront = rear + 1;

                // To check if we are again going back in the array but its of no use because we
                // have already checked (To avoid infinite loop)
                if (nextFront <= front) {
                    front++;
                } else {
                    // If front surpasses rear, set both front and rear to the next station
                    front = rear + 1;
                    rear = front;
                }
            }
        }

        // If no valid starting point is found, return -1
        return -1;
    }

    // More efficient approach
    public int canCompleteCircuit2(int[] gas, int[] cost) {

        // If the total sum of gas is less than the total sum of cost, return -1
        int sum = 0;
        for (int i = 0; i < gas.length; i++) {
            sum += gas[i] - cost[i];
        }

        if (sum < 0)
            return -1;

        // If the total sum of gas is greater than or equal to the total sum of cost, a
        // valid circuit exists at the starting point
        int start = 0;
        int total = 0;

        // Iterate through each gas station to find the starting point
        for (int i = 0; i < gas.length; i++) {
            total += gas[i] - cost[i];
            if (total < 0) {
                total = 0;
                start = i + 1;
            }
        }

        return start;
    }

}
