class Solution {
    private int f(int[] prices, int i, int buy, int[][] dp) {
        if(i == prices.length) return 0; 
        if(dp[i][buy] != -1) return dp[i][buy];

        int profit = 0;
        if(buy == 0) profit = Math.max(-prices[i] + f(prices, i+1, 1, dp), f(prices, i+1, 0, dp));
        else profit = Math.max(prices[i] + f(prices, i+1, 0, dp), f(prices, i+1, 1, dp));

        return dp[i][buy] = profit;
    }
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        for(int i=0; i<n; i++) Arrays.fill(dp[i], -1);
        return f(prices, 0, 0, dp);
    }
}