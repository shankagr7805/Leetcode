class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length; int n = grid[0].length;
        int[] prev = new int[n];
        prev[0] = grid[0][0];
        for(int i=1; i<n; i++) prev[i] = prev[i-1] + grid[0][i];

        for(int i=1; i<m; i++) {
            int[] curr = new int[n];
            curr[0] = prev[0] + grid[i][0];
            for(int j=1; j<n; j++) {
                curr[j] = (Math.min(prev[j] , curr[j-1])) + grid[i][j] ; 
            }
            prev = curr;
        }

        return prev[n-1];
    }
}