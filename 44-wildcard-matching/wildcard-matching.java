class Solution {
    private boolean f(String s, String t, int i, int j, int[][] dp) {
        if(i < 0 && j < 0) return true;
        if(j < 0) return false;
        if(i < 0) {
            for(int k = 0; k <= j; k++) {
                if(t.charAt(k) != '*') return false;
            }
            return true;
        }
        if(dp[i][j] != -1) return dp[i][j] == 1;
        boolean ans;
        if(s.charAt(i) == t.charAt(j) || t.charAt(j) == '?') {
            ans = f(s, t, i-1, j-1, dp);
        } else if(t.charAt(j) == '*') {
            ans = f(s, t, i-1, j, dp) || f(s, t, i, j-1, dp);
        } else {
            ans = false;
        }
        dp[i][j] = ans ? 1 : 0;
        return ans;
    }
    public boolean isMatch(String s, String p) {
        int n = s.length(); int m = p.length();
        int[][] dp = new int[n][m];
        for(int i=0; i<n; i++) Arrays.fill(dp[i], -1);
        return f(s, p, n-1, m-1,dp);
    }
}