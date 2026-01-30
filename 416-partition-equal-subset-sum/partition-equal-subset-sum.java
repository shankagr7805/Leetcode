class Solution {
    private boolean subsetSum(int[] nums, int k) {
        int n = nums.length;
        boolean[] prev = new boolean[k+1];
        prev[0] = true;
        if(nums[0] <= k) prev[nums[0]] = true;

        for(int i=1; i<n; i++) {
            boolean[] curr = new boolean[k+1];
            curr[0] = true;
            for(int j=1; j<=k; j++) {
                boolean notTake = prev[j];
                boolean take = false;
                if(nums[i] <= j) take = prev[j-nums[i]];
                curr[j] = take | notTake ;
            }
            prev = curr;
        }
        return prev[k];
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