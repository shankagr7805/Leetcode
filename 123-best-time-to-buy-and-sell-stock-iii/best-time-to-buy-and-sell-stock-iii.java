class Solution {
    private int f(int idx, int buy, int k, int[] prices, int[][][] dp) {
        if(idx == prices.length) return 0;
        int p = 0;
        if(k == 0) return 0;
        if(dp[idx][buy][k] != -1) return dp[idx][buy][k];
        if(buy == 1) {
            p = Math.max(-prices[idx] + f(idx+1, 0, k, prices, dp), f(idx+1, 1, k, prices, dp));
        } else {
            p = Math.max(prices[idx] + f(idx+1, 1, k-1, prices, dp), f(idx+1, 0, k, prices, dp));
        }
        return dp[idx][buy][k] = p;
    }
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n][2][3];
        for(int i=0; i<n; i++) {
            for(int j=0; j<3; j++) {
                dp[i][0][j] = -1;
                dp[i][1][j] = -1;
            }
        }
        return f(0, 1, 2, prices, dp);
    }
}