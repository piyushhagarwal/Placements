// There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.

// For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
// Return the ordering of courses you should take to finish all courses. If there are many valid answers, return any of them. If it is impossible to finish all courses, return an empty array.

// Example 1:

// Input: numCourses = 2, prerequisites = [[1,0]]
// Output: [0,1]
// Explanation: There are a total of 2 courses to take. To take course 1 you should have finished course 0. So the correct course order is [0,1].
// Example 2:

// Input: numCourses = 4, prerequisites = [[1,0],[2,0],[3,1],[3,2]]
// Output: [0,2,1,3]
// Explanation: There are a total of 4 courses to take. To take course 3 you should have finished both courses 1 and 2. Both courses 1 and 2 should be taken after you finished course 0.
// So one correct course order is [0,1,2,3]. Another correct ordering is [0,2,1,3].
// Example 3:

// Input: numCourses = 1, prerequisites = []
// Output: [0]

// Link : https://leetcode.com/problems/course-schedule-ii/
// Solution : https://www.youtube.com/watch?v=WAOfKpxYHR8

package Graphs.TopologicalSort;

import java.util.*;

class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // Adjacency list representation of the graph
        List<Integer>[] adj = new ArrayList[numCourses];
        // Indegree array to track the number of incoming edges for each node
        int[] indegree = new int[numCourses];
        // Map to track whether a course is included in the topological order
        Map<Integer, Boolean> map = new HashMap<>();

        // Initialize adjacency list
        for (int i = 0; i < numCourses; i++) {
            adj[i] = new ArrayList<>();
        }

        // Populate the adjacency list and calculate indegrees based on prerequisites
        for (int i = 0; i < prerequisites.length; i++) {
            adj[prerequisites[i][1]].add(prerequisites[i][0]);
            indegree[prerequisites[i][0]]++;
        }

        // Array to store the topological ordering of courses
        int[] topoSort = new int[numCourses];

        // Queue to store courses with indegree 0
        Queue<Integer> queue = new LinkedList<>();

        // Initialize the queue with courses having no prerequisites
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }

        int index = 0;
        // Process courses in the queue and update indegrees
        while (!queue.isEmpty()) {
            int poppedElement = queue.poll();
            map.put(poppedElement, true);
            topoSort[index] = poppedElement;
            index++;

            // Update indegrees of the neighbors and add to the queue if their indegree
            // becomes 0
            for (int neighbor : adj[poppedElement]) {
                indegree[neighbor]--;
                if (indegree[neighbor] == 0) {
                    queue.add(neighbor);
                }
            }
        }

        // If the topological order has all courses, return it; otherwise, return an
        // empty array
        if (map.size() != numCourses) {
            return new int[0];
        }

        return topoSort;
    }
}
