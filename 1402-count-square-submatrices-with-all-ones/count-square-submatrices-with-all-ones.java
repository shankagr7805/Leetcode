class Solution {
    private int f(int[][] matrix, int i, int j, int[][] dp) {
        if(matrix[i][j] == 0) return 0;
        if(dp[i][j] != -1) return dp[i][j];

        int l = 0; int u = 0; int dia = 0;
        if(i>0) u = f(matrix, i-1, j, dp);
        if(j>0) l = f(matrix, i, j-1, dp);
        if(i>0 && j>0) dia = f(matrix, i-1, j-1, dp);

        return dp[i][j] = Math.min(l, Math.min(u, dia)) + 1;
    }
    public int countSquares(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length; int sum = 0;
        int[][] dp = new int[n][m];

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(matrix[i][j] == 0) continue;

                int l = 0; int u = 0; int dia = 0;
                if(i>0) u = dp[i-1][j];
                if(j>0) l = dp[i][j-1];
                if(i>0 && j>0) dia = dp[i-1][j-1];

                dp[i][j] = Math.min(l, Math.min(u, dia)) + 1;

                sum += dp[i][j];
            }
        }
        return sum;
    }
}