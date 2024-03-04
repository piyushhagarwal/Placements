// There are n computers numbered from 0 to n - 1 connected by ethernet cables connections forming a network where connections[i] = [ai, bi] represents a connection between computers ai and bi. Any computer can reach any other computer directly or indirectly through the network.

// You are given an initial computer network connections. You can extract certain cables between two directly connected computers, and place them between any pair of disconnected computers to make them directly connected.

// Return the minimum number of times you need to do this in order to make all the computers connected. If it is not possible, return -1.

// Example 1:

// Input: n = 4, connections = [[0,1],[0,2],[1,2]]
// Output: 1
// Explanation: Remove cable between computer 1 and 2 and place between computers 1 and 3.
// Example 2:

// Input: n = 6, connections = [[0,1],[0,2],[0,3],[1,2],[1,3]]
// Output: 2
// Example 3:

// Input: n = 6, connections = [[0,1],[0,2],[0,3],[1,2]]
// Output: -1
// Explanation: There are not enough cables.

// Link : https://leetcode.com/problems/number-of-operations-to-make-network-connected/
// Solution : https://www.youtube.com/watch?v=FYrl7iz9_ZU

package Graphs.MSTDisjointSet;

class Solution {
    class DST {
        int[] parent;
        int[] size;

        public DST(int n) {
            parent = new int[n];
            size = new int[n];

            for (int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        public int ep(int node) {
            if (parent[node] == node) {
                return node;
            }

            int eventualParent = ep(parent[node]);
            parent[node] = eventualParent;
            return parent[node];
        }

        public void union(int node1, int node2) {
            int ep1 = ep(node1);
            int ep2 = ep(node2);
            if (ep1 == ep2) {
                return;
            } else {
                if (size[ep1] > size[ep2]) {
                    parent[ep2] = ep1;
                    size[ep1] += size[ep2];
                } else {
                    parent[ep1] = ep2;
                    size[ep2] += size[ep1];
                }
            }
        }
    }

    public int makeConnected(int n, int[][] connections) {
        DST ds = new DST(n);
        int extraEdges = 0;
        for (int i = 0; i < connections.length; i++) {
            int u = connections[i][0];
            int v = connections[i][1];

            if (ds.ep(u) == ds.ep(v)) {
                extraEdges++;
            } else {
                ds.union(u, v);
            }
        }

        int distinctConnections = 0;
        for (int i = 0; i < n; i++) {
            if (ds.parent[i] == i) {
                distinctConnections++;
            }
        }
        if (distinctConnections - 1 == 0 && extraEdges == 0) {
            return 0;
        }
        if (distinctConnections - 1 <= extraEdges) {
            return distinctConnections - 1;
        }
        return -1;
    }
}