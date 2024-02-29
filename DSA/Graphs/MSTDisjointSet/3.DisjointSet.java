// Solution : https://www.youtube.com/watch?v=aBxjDBC4M1U

package Graphs.MSTDisjointSet;

class DisjointSet {
    int parent[]; // To store the parent of each node
    int size[]; // To store the size of each set

    public DisjointSet(int n) {
        parent = new int[n];
        size = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i; // Initially, each node is the parent of itself
            size[i] = 1; // Initially, each set has only one node
        }
    }

    // Method to find ultimate parent of a node
    public int findUltimateParent(int node) {
        if (parent[node] == node) {
            return node;
        }

        // Path compression
        int ultimateParent = findUltimateParent(parent[node]);
        parent[node] = ultimateParent;
        return parent[node];
    }

    // Method to merge two sets
    public void union(int node1, int node2) {
        int ultimateParent1 = findUltimateParent(node1);
        int ultimateParent2 = findUltimateParent(node2);

        // If both nodes are already in the same set, return
        if (ultimateParent1 == ultimateParent2) {
            return;
        }

        // Merge the smaller set into the larger set
        if (size[ultimateParent1] < size[ultimateParent2]) {
            parent[ultimateParent1] = ultimateParent2;
            size[ultimateParent2] += size[ultimateParent1];
        } else {
            parent[ultimateParent2] = ultimateParent1;
            size[ultimateParent1] += size[ultimateParent2];
        }
    }
}
