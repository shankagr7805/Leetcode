class Solution {
    public int maxFrequency(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);
        int l = 0;
        int mx = 1;
        long sum = 0;
        for (int r = 0; r < n; r++) {
            sum += nums[r];
        
            while ((long)nums[r] * (r - l + 1) > k + sum) {
                sum -= nums[l];
                l++;
            }
            mx = Math.max(mx, r - l + 1);
        }
        return mx;
    }
}