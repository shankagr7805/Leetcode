class Solution {
    public boolean canJump(int[] nums) {
        int max_i = 0; 

        for(int i=0; i<nums.length; i++) {
            if(i > max_i) return false;
            max_i = Math.max(max_i , i + nums[i]);
        }
        return true;
    }
}