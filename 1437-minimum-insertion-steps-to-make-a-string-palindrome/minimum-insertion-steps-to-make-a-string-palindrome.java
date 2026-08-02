class Solution {
    private int lcs(String s, String t) {
        int n = s.length(); 
        int[][] dp = new int[n+1][n+1];
        for(int i=1; i<=n; i++) {
            for(int j=1; j<=n; j++) {
                if(s.charAt(i-1) == t.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[n][n];
    }
    public int minInsertions(String s) {
        int n = s.length();
        StringBuilder sb = new StringBuilder();
        for(int i=n-1; i>=0; i--) {
            sb.append(s.charAt(i));
        }
        String t = sb.toString();
        int x = lcs(s, t);

        return n-x;
    }
}