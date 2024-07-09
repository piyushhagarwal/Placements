// Given an integer array nums, find the 
// subarray
//  with the largest sum, and return its sum.

// Example 1:

// Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
// Output: 6
// Explanation: The subarray [4,-1,2,1] has the largest sum 6.
// Example 2:

// Input: nums = [1]
// Output: 1
// Explanation: The subarray [1] has the largest sum 1.
// Example 3:

// Input: nums = [5,4,-1,7,8]
// Output: 23
// Explanation: The subarray [5,4,-1,7,8] has the largest sum 23.

// Link : https://leetcode.com/problems/maximum-subarray/
// Solution : https://www.youtube.com/watch?v=w4W6yya1PIc&t=633s

//Kadanes Algo is a solution to this problem which solves it with O(n) time complexity. 

package Arrays;

class KadanesAlgo {

    static int kadanesAlgo(int arr[]) {
        int maxSoFar = Integer.MIN_VALUE; // Integer.MIN_VALUE is used to handle the case when all the elements are
                                          // negative
        int maxEndingHere = 0; // This variable is used to keep track of the sum of the subarray ending at the
                               // current index

        for (int i = 0; i < arr.length; i++) {

            // Step 1: Add the current element to maxEndingHere variable
            maxEndingHere += arr[i];

            // Step 2: Check if the maxSoFar is less than maxEndingHere, if yes then update
            if (maxSoFar < maxEndingHere) {
                maxSoFar = maxEndingHere;
            }

            // Step 3: If maxEndingHere is less than 0, then update it to 0
            if (maxEndingHere < 0) {
                maxEndingHere = 0;
            }
        }

        return maxSoFar;
    }

    public static void main(String args[]) {
        int arr[] = { -2, -3, -2, -1, -5 };
        System.out.println(kadanesAlgo(arr));
    }
}