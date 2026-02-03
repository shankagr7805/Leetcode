class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length; int k = amount;
        int[][] dp = new int[n][k+1];
        for(int j=0; j<k+1; j++) {
            if(j % coins[0] == 0) {
                dp[0][j] = 1;
            } else {
                dp[0][j] = 0;
            }
        }

        for(int i=1; i<n; i++) {
            for(int j=0; j<=k; j++) {
                int notTake = dp[i-1][j];
                int take = 0;
                if(coins[i] <= j) {
                    take = dp[i][j-coins[i]];
                }
                dp[i][j] = take + notTake;
            }
        }

        return dp[n-1][k];
    }
}