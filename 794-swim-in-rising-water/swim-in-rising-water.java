class Solution {
    private int[] dr = {-1, 0, 1, 0};
    private int[] dc = {0, 1, 0, -1};
    private boolean posToReach(int[][] grid, int i, int j, int t, boolean[][] vis) {
        int n = grid.length;
        if(i<0 || i>=n || j<0 || j>=n || vis[i][j] == true || grid[i][j] > t) {
            return false;
        }
        vis[i][j] = true;
        if(i==n-1 && j==n-1) return true; 

        for(int k=0; k<4; k++) {
            int _i = i + dr[k];
            int _j = j + dc[k];

            if(posToReach(grid, _i, _j, t, vis)) return true;
        }
        return false;
    }
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        int l = 0; int r = n*n - 1;
        int result = 0;

        while(l <= r) {
            int mid = l + (r - l) / 2;
            boolean[][] vis = new boolean[n][n];
            if(posToReach(grid, 0, 0, mid, vis)) {
                result = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return result;
    }
}