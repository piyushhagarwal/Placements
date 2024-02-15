// There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.

// For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
// Return true if you can finish all courses. Otherwise, return false.

// Example 1:

// Input: numCourses = 2, prerequisites = [[1,0]]
// Output: true
// Explanation: There are a total of 2 courses to take. 
// To take course 1 you should have finished course 0. So it is possible.
// Example 2:

// Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
// Output: false
// Explanation: There are a total of 2 courses to take. 
// To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So it is impossible.

// Link : https://leetcode.com/problems/course-schedule/
// Solution : https://www.youtube.com/watch?v=WAOfKpxYHR8

package Graphs.TopologicalSort;

import java.util.*;

// It is similar to the problem of detecting cycles in a directed graph.
// The only difference is the prerequisites elements are in the form of edges which is in reverse order

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // Adjacency list representation of the graph
        List<Integer>[] adj = new ArrayList[numCourses];
        // Indegree array to track the number of incoming edges for each node
        int[] indegree = new int[numCourses];

        // Initialize adjacency list
        for (int i = 0; i < numCourses; i++) {
            adj[i] = new ArrayList<>();
        }

        // Populate the adjacency list and calculate indegrees based on prerequisites
        for (int i = 0; i < prerequisites.length; i++) {
            adj[prerequisites[i][1]].add(prerequisites[i][0]);
            indegree[prerequisites[i][0]]++;
        }

        // List to store the topological ordering of courses
        List<Integer> topoSort = new ArrayList<>();

        // Queue to store courses with indegree 0
        Queue<Integer> queue = new LinkedList<>();

        // Initialize the queue with courses having no prerequisites
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }

        // Process courses in the queue and update indegrees
        while (!queue.isEmpty()) {
            int poppedElement = queue.poll();
            topoSort.add(poppedElement);

            // Update indegrees of the neighbors and add to the queue if their indegree
            // becomes 0
            for (int neighbor : adj[poppedElement]) {
                indegree[neighbor]--;
                if (indegree[neighbor] == 0) {
                    queue.add(neighbor);
                }
            }
        }

        // If the topological order has all courses, return true (possible to finish all
        // courses)
        return topoSort.size() == numCourses;
    }
}
