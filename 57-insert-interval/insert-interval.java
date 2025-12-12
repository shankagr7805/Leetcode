class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
    //     int m = intervals.length;
    //     int[][] a = new int[m+1][2];

    //     for(int i = 0; i < m + 1; i++){
    //         if(i == m){
    //             a[i] = newInterval;
    //         } else {
    //             a[i] = intervals[i];
    //         }
    //     }
    //     Arrays.sort(a, (x, y) -> Integer.compare(x[0], y[0]));

    //     List<int[]> merged = new ArrayList<>();
    //     int[] cur = a[0];
    //     for (int i = 1; i < a.length; i++) {
    //         if (a[i][0] <= cur[1]) {               
    //             cur[1] = Math.max(cur[1], a[i][1]); 
    //         } else {
    //             merged.add(cur);                  
    //             cur = a[i];                         
    //         }
    //     }
    //     merged.add(cur); 

    //     int[][] result = new int[merged.size()][2];
    //     for (int i = 0; i < merged.size(); i++) result[i] = merged.get(i);

    //     return result;

        List<int[]> res = new ArrayList<>();
        int i = 0, n = intervals.length;

        while (i < n && intervals[i][1] < newInterval[0]) {
            res.add(intervals[i]);
            i++;
        }

        while (i < n && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        res.add(newInterval);

        while (i < n) {
            res.add(intervals[i]);
            i++;
        }
        return res.toArray(new int[res.size()][]);
    }
}