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

    public int total(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        return sum;
    }

    public boolean split(int[] nums, int k, int subarr) {
        int sum = 0; int count = 1;
        for(int num : nums) {
            sum += num ;
            if(sum > subarr) {
                count++;
                sum = num;
                if(count > k) {
                    return false;
                }
            }
        }
        return true;
    }

    public int splitArray(int[] nums, int k) {
        int n = nums.length;
        int low = maximum(nums);
        int high = total(nums);
        int ans = -1;

        while(low <= high) {
            int mid = low + (high - low) / 2 ;

            if(split(nums, k, mid)) {
                ans = mid;
                high = mid - 1;
            }  else {
                low = mid + 1;
            }
        }
        return ans;
    }
}