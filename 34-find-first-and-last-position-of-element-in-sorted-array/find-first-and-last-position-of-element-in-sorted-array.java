class Solution {
    public int[] searchRange(int[] nums, int target) {
        int n = nums.length;
        int first = -1; int last = -1;
        int count = 0;
        for(int i=0; i<n; i++) {
            if(nums[i] == target) {
                count++;
            }
        }
        for(int i = 0; i<n ; i++) {
            if(nums[i] == target) {
                first = i ;
                last = i + (count-1) ;   
                break;
            }
        }

        return new int[] {first , last};
    }
}