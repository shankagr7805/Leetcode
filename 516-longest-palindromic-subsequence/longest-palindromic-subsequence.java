class Solution {
    private int f(String s, int i, int j, int[][] dp) {
        if(i > j) return 0;
        if(i == j) return 1;
        if(dp[i][j] != -1) return dp[i][j];
        int eq = 0; int neq = 0;
        if(s.charAt(i) == s.charAt(j)) {
            eq = f(s, i+1, j-1, dp) + 2;
        } else {
            eq = f(s, i+1, j, dp);
            neq = f(s, i, j-1, dp);
        }

        return dp[i][j] = Math.max(eq, neq);
    }
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        for(int i=0; i<n; i++) Arrays.fill(dp[i], -1);
        return f(s, 0, n-1, dp);
    }
} 