class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[n][n];
        for(int i=0; i<n; i++) {
            Arrays.fill(dp[i], (int) 1e9);
        }
        dp[0][0] = triangle.get(0).get(0);

        for(int i=1; i<n; i++) {
            for(int j=0; j<triangle.get(i).size(); j++) {
                if(j-1 >= 0) dp[i][j] = Math.min(dp[i-1][j], dp[i-1][j-1]) + triangle.get(i).get(j);
                else dp[i][j] = dp[i-1][j] + triangle.get(i).get(j);
            }
        }
        int mini = dp[n-1][0];
        for(int i=1; i<n; i++) {
            mini = Math.min(mini, dp[n-1][i]);
        }
        return mini;
    }
}