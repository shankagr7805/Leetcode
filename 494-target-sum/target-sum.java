class Solution {
    private int f(int[] nums, int i, int k, int[][] dp) {
        if(i==0) {
            if(k == 0 && nums[0] == 0) return 2;
            if(k == 0 || nums[0] == k) return 1;
            return 0;
        }
        if(dp[i][k] != -1) return dp[i][k];
        int add = f(nums, i-1, k, dp);
        int sub = 0;
        if(nums[i]<=k) sub = f(nums, i-1, k-nums[i], dp);

        return dp[i][k] = add + sub;
    }
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        int sum = 0;
        for(int i=0; i<n; i++) sum += nums[i];
        if(sum < Math.abs(target)) return 0;
        if((sum+target) % 2 != 0) return 0;

        int j = (sum + target) / 2;
        int k = Math.abs(j);
        int[][] dp = new int[n][k+1];
        for(int i=0; i<n; i++) Arrays.fill(dp[i], -1);
        return f(nums, n-1, k, dp);
    }
}