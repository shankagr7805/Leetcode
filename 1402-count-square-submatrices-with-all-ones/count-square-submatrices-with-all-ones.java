class Solution {
    public int countSquares(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] dp = new int[n][m];
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(matrix[i][j] == 0) continue;
                int left = 0; int right = 0; int diag = 0;
                if(i>0) left = dp[i-1][j];
                if(j>0) right = dp[i][j-1];
                if(i>0 && j>0) diag = dp[i-1][j-1];
                dp[i][j] = Math.min(left, Math.min(right, diag)) + 1;
            }
        }
        int sum = 0;
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                sum += dp[i][j];
            }
        }
        return sum;
    }
}