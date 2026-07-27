class Solution {
    private int f(int[][] grid, int i, int j, int[][] dp) {
        if(i==0 && j==0) return grid[0][0];
        if (i < 0 || j < 0) return (int)1e9;
        if(dp[i][j] != -1) return dp[i][j];
        int up = f(grid, i-1, j, dp);
        int left = f(grid, i, j-1, dp);
        int ans = Math.min(up, left);

        return dp[i][j] = grid[i][j] + ans;
    }
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        for(int i=0; i<m; i++) {
            Arrays.fill(dp[i], -1);
        }
        return f(grid, m-1, n-1, dp);
    }
}