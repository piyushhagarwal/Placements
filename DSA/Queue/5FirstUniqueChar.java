// Given a string s, find the first non-repeating character in it and return its index. If it does not exist, return -1.

// Example 1:

// Input: s = "leetcode"
// Output: 0
// Example 2:

// Input: s = "loveleetcode"
// Output: 2
// Example 3:

// Input: s = "aabb"
// Output: -1

// Link : https://leetcode.com/problems/first-unique-character-in-a-string/

package Queue;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

class FirstUniqueChar {
    public int firstUniqChar(String s) {
        // Create a HashMap to store the count of each character in the string
        HashMap<Character, Integer> map = new HashMap<>();

        // Create a queue to keep track of the indices of unique characters
        Queue<Integer> queue = new LinkedList<>();

        // Step 1: Traverse the string and populate the HashMap and queue
        for (int i = 0; i < s.length(); i++) {
            // If the character is not in the HashMap, add it to the queue and set count to
            // 1
            if (!map.containsKey(s.charAt(i))) {
                queue.add(i); // Add the index to the queue
                map.put(s.charAt(i), 1); // Set count to 1 for the character
            } else {
                // If the character is already in the HashMap, increment the count
                int count = map.get(s.charAt(i));
                map.put(s.charAt(i), count + 1);
            }
        }

        // Step 2: Traverse the queue to find the first unique character
        while (!queue.isEmpty()) {
            int topIndex = queue.peek(); // Get the index from the front of the queue

            // If the count of the character at the current index is 1, it is unique
            if (map.get(s.charAt(topIndex)) == 1) {
                return topIndex; // Return the index of the first unique character
            } else {
                queue.poll(); // Remove the index from the queue as it is not unique
            }
        }

        // If no unique character is found, return -1
        return -1;
    }

}
