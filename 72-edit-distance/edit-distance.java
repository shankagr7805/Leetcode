class Solution {
    private int f(String s, String t, int i, int j, int[][] dp) {
        if(i<0) return j+1;
        if(j<0) return i+1;
        if(dp[i][j] != -1) return dp[i][j];
        if(s.charAt(i) == t.charAt(j)) {
            return dp[i][j] = f(s, t, i-1, j-1, dp);
        } else {
            return dp[i][j] = 1 + Math.min(f(s, t, i-1, j, dp), Math.min(f(s, t, i, j-1, dp), f(s, t, i-1, j-1, dp)));
        }
    }
    public int minDistance(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();
        int[][] dp = new int[n][m];
        for(int i=0; i<n; i++) Arrays.fill(dp[i], -1);
        return f(str1, str2, n-1, m-1, dp);
    }
}