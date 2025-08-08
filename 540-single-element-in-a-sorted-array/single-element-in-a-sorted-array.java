class Solution {
    public int singleNonDuplicate(int[] nums) {
        int n = nums.length;
        int low = 0; int high = 1; 

        while(high < n-1) {
            if(nums[low] != nums[high]) {
                return nums[low] ; 
            } else {
                low += 2 ;
                high += 2;
            }
        }
        return nums[n-1];
    }
}