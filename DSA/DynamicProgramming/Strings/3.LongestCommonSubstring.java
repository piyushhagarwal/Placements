// You are given two strings, 'str1' and 'str2'. You have to find the length of the longest common substring.

// A substring is a continuous segment of a string. For example, "bcd" is a substring of "abcd", while "acd" or "cda" are not.

// Example:
// Input: ‘str1’ = “abcjklp” , ‘str2’ = “acjkp”.

// Output: 3

// Explanation:  The longest common substring between ‘str1’ and ‘str2’ is “cjk”, of length 3.
// Detailed explanation ( Input/output format, Notes, Images )
// Sample Input 1:
// wasdijkl
// wsdjkl
// Sample Output 1:
//  3
// Explanation Of Sample Input 1 :
//  The longest common substring is “jkl”, of length 3.
// Sample Input 2:
// tyfg
// cvbnuty
// Sample Output 2:
// 2
// Explanation Of Sample Input 2 :
// The longest common substring is “ty”, of length 2.
// Expected time complexity:
// The expected time complexity is O(n*m),
// Where ‘n’ and ‘m’ are the lengths of ‘st1’ and ‘str2’ respectively.

// Link : https://www.codingninjas.com/studio/problems/longest-common-substring_1235207?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf&leftPanelTabValue=PROBLEM
// Solution : https://www.youtube.com/watch?v=_wP9mWNPL5w

package DynamicProgramming.Strings;

class Solution {

    // Function to find the length of the Longest Common Subsequence (LCS)
    public static int lcs(String str1, String str2) {
        // Get the lengths of the input strings
        int m = str1.length();
        int n = str2.length();

        // Create a 2D array to store the length of LCS at each position
        int arr[][] = new int[m][n];

        // Variable to store the final result (length of LCS)
        int ans = 0;

        // Iterate over each character in both strings
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // Check if the characters at the current positions are the same
                if (str1.charAt(i) == str2.charAt(j)) {
                    // If the characters are the same, update arr[i][j] based on the diagonal entry
                    // If diagonal entry is non-zero, extend the common subsequence
                    if (i - 1 >= 0 && j - 1 >= 0 && arr[i - 1][j - 1] != 0) {
                        arr[i][j] = 1 + arr[i - 1][j - 1];
                    } else {
                        arr[i][j] = 1;
                    }
                } else {
                    // If characters are different, set the arr[i][j] entry to 0
                    arr[i][j] = 0;
                }

                // Update ans with the maximum value encountered in the process
                ans = Math.max(arr[i][j], ans);
            }
        }

        // Return the final length of the Longest Common Subsequence
        return ans;
    }
}
