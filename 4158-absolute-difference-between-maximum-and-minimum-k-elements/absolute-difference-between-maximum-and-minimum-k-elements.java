class Solution {
    public int absDifference(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums); 
        int sum_l = 0; int sum_s = 0;
        for(int i=0; i<k; i++) {
            sum_s += nums[i];
        }
        for(int i=n-1; i>=n-k; i--) {
            sum_l += nums[i];
        }
        return Math.abs(sum_l - sum_s);
    }
}