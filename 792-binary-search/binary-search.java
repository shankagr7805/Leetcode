class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int low = 0;
        int high = n-1;

        if(n==1 && nums[0] == target) {
            return 0;
        }
        if(n==2) {
            if(nums[0]==target) {
                return 0;
            } else if(nums[1] == target){
                return 1;
            } else {
                return -1;
            }
        }
        while(low<=high) {
            int mid = (low+high) / 2 ;
            if(nums[mid] == target) {
                return mid ;
            } else {
                if(nums[mid] < target) {
                    low = mid+1 ;
                } else { 
                    high = mid - 1 ;
                }
            }
        }
        return -1;
    }
}