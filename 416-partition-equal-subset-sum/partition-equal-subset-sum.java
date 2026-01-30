class Solution { 
    public boolean canPartition(int[] nums) {
        int n = nums.length; int sum = 0;
        for(int i=0; i<n; i++) {
            sum += nums[i];
        }
        if(sum % 2 != 0) return false;
        sum = sum/2;
        
        boolean[] dp = new boolean[sum+1];
        dp[0] = true;

        for(int i=1; i<n; i++) {
            for(int j=sum; j>0; j--) {
                if (j - nums[i - 1] < 0) dp[j] = dp[j];
                else dp[j] = dp[j-nums[i-1]] || dp[j];
            }
        }

        return dp[sum];
    }
}