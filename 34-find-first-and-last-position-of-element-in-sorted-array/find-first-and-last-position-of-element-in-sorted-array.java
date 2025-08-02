class Solution {
    public int first_element(int[] nums, int target) {
        for(int i=0; i<nums.length; i++) {
            if(nums[i] == target) {
                return i;
            }
        }
        return -1;
    }
    public int last_element(int[] nums, int target) {
        for(int i = nums.length - 1; i>=0; i--) {
            if(nums[i] == target) {
                return i;
            }
        }
        return -1;
    }
    public int[] searchRange(int[] nums, int target) {
        int[] ans = new int[2];
        ans[0] = first_element(nums, target);
        ans[1] = last_element(nums, target) ;
        
        return ans;
    }
}