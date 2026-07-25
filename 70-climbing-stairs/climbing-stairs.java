class Solution {
    private int f(int n, int[] dp) {
        if(n<=1) return 1;
        if(dp[n]!=0) return dp[n];
        int one = f(n-1, dp);
        int two = f(n-2, dp);
        return dp[n] = one + two;
    }
    public int climbStairs(int n) {
        int[] dp = new int[n+1];
        return f(n, dp);
    }
}