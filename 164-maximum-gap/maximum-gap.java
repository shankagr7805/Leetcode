class Solution {
    public int maximumGap(int[] nums) {
        Arrays.sort(nums);
        int max_diff = 0; 
        if(nums.length==1) return max_diff;
        for(int i=0; i<nums.length-1; i++) {
            max_diff = Math.max((nums[i+1] - nums[i]), max_diff);
        }
        return max_diff;
    }
}