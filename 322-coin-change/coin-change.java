class Solution {
    private int f(int[] coins, int i, int k, int[][] dp) {
        if(i == 0) {
            if(k % coins[i] == 0) return k/coins[i];
            return (int)1e9;
        }
        if(dp[i][k] != -1) return dp[i][k];
        int notTake = f(coins, i-1, k, dp);
        int take = Integer.MAX_VALUE;
        if(coins[i] <= k) take = 1 + f(coins, i, k-coins[i], dp);

        return dp[i][k] = Math.min(take, notTake);
    }
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n][amount+1];
        for(int i=0; i<n; i++) Arrays.fill(dp[i], -1);
        int ans = f(coins, n-1, amount, dp);
        return (ans != (int)1e9) ? ans : -1;
    }
}