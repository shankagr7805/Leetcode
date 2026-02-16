class Solution {
    private boolean f(String s, String p, int i, int j, int[][] dp) {
        if(i<0 && j<0) return true;
        if(j<0) return false;
        if(i < 0) {
            for(int k = 0; k <= j; k++) {
                if(p.charAt(k) != '*') return false;
            }
            return true;
        }
        if(dp[i][j] != -1) return dp[i][j] == 1;
        boolean ans = false;
        if(p.charAt(j) == '*') {
            ans = f(s, p, i, j-1, dp) || f(s, p, i-1, j, dp);
        }
        if (p.charAt(j) == '?' || s.charAt(i) == p.charAt(j)) ans = f(s, p, i-1, j-1, dp);
        
        dp[i][j] = ans ? 1 : 0;

        return ans;
    }
    public boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();
        int[][] dp = new int[n][m];
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                dp[i][j] = -1;
            }
        }
        return f(s, p, n-1, m-1, dp);
    }
}