class Solution {
    public int maximum(int[] nums) {
        int n = nums.length;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if (nums[i] > max) {
                max = nums[i];
            }
        }
        return max;
    }

    public boolean canBeChosen(int[] nums, int threshold, int divisor) {
        int n = nums.length; int sum = 0;
        for(int i=0; i<n; i++) {
            sum += (int) Math.ceil((double)nums[i] / divisor) ;
        }
        if(sum <= threshold) {
            return true;
        }
        return false ;
    }
    public int smallestDivisor(int[] nums, int threshold) {
        int n = nums.length;
        int low = 1;
        int high = maximum(nums);
        int ans = -1;
        while(low <= high) {
            int mid = low + (high - low) / 2 ;
            boolean div = canBeChosen(nums, threshold, mid) ;
            if(div) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }
}