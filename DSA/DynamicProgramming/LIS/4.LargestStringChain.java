// You are given an array of words where each word consists of lowercase English letters.

// wordA is a predecessor of wordB if and only if we can insert exactly one letter anywhere in wordA without changing the order of the other characters to make it equal to wordB.

// For example, "abc" is a predecessor of "abac", while "cba" is not a predecessor of "bcad".
// A word chain is a sequence of words [word1, word2, ..., wordk] with k >= 1, where word1 is a predecessor of word2, word2 is a predecessor of word3, and so on. A single word is trivially a word chain with k == 1.

// Return the length of the longest possible word chain with words chosen from the given list of words.

// Example 1:

// Input: words = ["a","b","ba","bca","bda","bdca"]
// Output: 4
// Explanation: One of the longest word chains is ["a","ba","bda","bdca"].
// Example 2:

// Input: words = ["xbc","pcxbcf","xb","cxbc","pcxbc"]
// Output: 5
// Explanation: All the words can be put in a word chain ["xb", "xbc", "cxbc", "pcxbc", "pcxbcf"].
// Example 3:

// Input: words = ["abcd","dbqca"]
// Output: 1
// Explanation: The trivial word chain ["abcd"] is one of the longest word chains.
// ["abcd","dbqca"] is not a valid word chain because the ordering of the letters is changed.

// Link : https://leetcode.com/problems/longest-string-chain/
// Solution : https://www.youtube.com/watch?v=YY8iBaYcc4g

package DynamicProgramming.LIS;

import java.util.Arrays;

// By recursion
class Solution {
    public boolean compare(String curr, String prev) {
        if (curr.length() != prev.length() + 1) {
            return false;
        }
        int i = 0;
        int j = 0;
        while (i < curr.length() && j < prev.length()) {
            if (curr.charAt(i) == prev.charAt(j)) {
                i++;
                j++;
            } else {
                i++;
            }
        }

        if (j == prev.length()) {
            return true;
        }

        return false;

    }

    public int solve(int currIndex, int prevIndex, String[] words) {
        if (currIndex >= words.length) {
            return 0;
        }

        int include = Integer.MIN_VALUE;
        if (prevIndex == -1 || compare(words[currIndex], words[prevIndex])) {
            include = 1 + solve(currIndex + 1, currIndex, words);
        }

        int exclude = solve(currIndex + 1, prevIndex, words);

        return Math.max(include, exclude);
    }

    public int longestStrChain(String[] words) {
        Arrays.sort(words, (s1, s2) -> Integer.compare(s1.length(), s2.length()));
        int currIndex = 0;
        int prevIndex = -1;
        return solve(currIndex, prevIndex, words);
    }
}
