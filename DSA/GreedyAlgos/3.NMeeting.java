// Link : https://www.geeksforgeeks.org/problems/n-meetings-in-one-room-1587115620/1

// Intuition:

// The idea is to sort the meetings based on their end times. We can then greedily select meetings that end early, allowing us to accommodate more meetings overall.

// Implementation:

// Create pairs of meetings with their start and end times.
// Sort the meetings based on their end times.
// Iterate through the sorted meetings and keep track of the last end time.
// If the current meeting's start time is after the last end time, select the meeting.

package GreedyAlgos;

import java.util.Arrays;

class pair {
    int first, second;

    public pair(int start, int finish) {
        this.first = start;
        this.second = finish;
    }
}

class Solution {
    // Function to find the maximum number of meetings that can
    // be performed in a meeting room.
    public static int maxMeetings(int start[], int end[], int n) {
        pair[] x = new pair[n];

        // pushing the pair of starting and finish time in a list.
        for (int i = 0; i < n; i++) {
            x[i] = new pair(start[i], end[i]);
        }

        // comparator function used in sorting the list of pairs
        // according to increasing order of the finish time.
        Arrays.sort(x, (a, b) -> a.second - b.second);

        int last = -1;
        int res = 0;
        for (int i = 0; i < n; i++) {
            // if the start time of this meeting is greater than or equal
            // to the finish time of previously selected meeting then
            // we increment the counter and update last.
            if (x[i].first > last) {
                res++;
                last = x[i].second;
            }
        }
        // returning the counter.
        return res;
    }
}
