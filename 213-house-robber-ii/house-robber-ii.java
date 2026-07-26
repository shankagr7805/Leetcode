class Solution {
    private int f(int[] nums, int i, int[] dp) {
        if(i==0) return nums[0];
        if(i<0) return 0;
        if(dp[i] != -1) return dp[i];
        int take = f(nums, i-2, dp) + nums[i];
        int not = f(nums, i-1, dp);

        return dp[i] = Math.max(take, not);
    }
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];
        int[] temp1 = new int[n-1];
        int[] temp2 = new int[n-1];
        for(int i=0; i<n-1; i++) {
            temp1[i] = nums[i];
        }
        for(int i=1; i<n; i++) {
            temp2[i-1] = nums[i];
        }
        int[] dp = new int[n-1];
        Arrays.fill(dp, -1);
        int a = f(temp1, n-2, dp);
        Arrays.fill(dp, -1);
        int b = f(temp2, n-2, dp);

        return Math.max(a, b);
    }
} 