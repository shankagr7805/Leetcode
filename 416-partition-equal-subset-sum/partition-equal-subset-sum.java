class Solution {
    private boolean subsetSum(int[] nums, int k) {
        int n = nums.length;
        boolean[][] dp = new boolean[n][k+1];
        for(int i=0; i<n; i++) dp[i][0] = true;
        if(nums[0] <= k) dp[0][nums[0]] = true;

        for(int i=1; i<n; i++) {
            for(int j=1; j<=k; j++) {
                boolean notTake = dp[i-1][j];
                boolean take = false;
                if(nums[i] <= j) take = dp[i-1][j-nums[i]];
                dp[i][j] = take | notTake ;
            }
        }
        return dp[n-1][k];
    } 
    public boolean canPartition(int[] nums) {
        int n = nums.length; int sum = 0;
        for(int i=0; i<n; i++) {
            sum += nums[i];
        }
        if(sum % 2 != 0) return false;
        return subsetSum(nums, sum/2);
    }
}