class Solution {
    private int preSum(int[] nums, int goal) {
        if(goal < 0) return 0;
        int l = 0, r = 0, cnt = 0, sum = 0;
        
        while(r < nums.length) {
            sum += nums[r];
            while(sum > goal) {
                sum -= nums[l];
                l++;
            }
            cnt += r-l+1 ;
            r++;
        }
        return cnt;
    }
    public int numSubarraysWithSum(int[] nums, int goal) {
        return preSum(nums, goal) - preSum(nums, goal-1);
    }
}