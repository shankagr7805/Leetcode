class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {

        if (intervals == null || intervals.length == 0) return -1;
        Arrays.sort(intervals, (a,b) -> a[1]-b[1]);

        int removed = 0;
        int[] prev = intervals[0];

        for (int i = 1; i < intervals.length; i++) {
            int[] curr = intervals[i];

            if( prev[1] > curr[0]) removed++;
            else 
                prev = curr;
        }

        return removed;
    }
}