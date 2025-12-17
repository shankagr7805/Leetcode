class Solution {
    public int maxProduct(int[] nums) {
        int mx = nums[0];
        int mn = nums[0];
        int ans = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int curr = nums[i];

            int tempMax = mx;

            mx = Math.max(curr, Math.max(curr * mx, curr * mn));
            mn = Math.min(curr, Math.min(curr * tempMax, curr * mn));

            ans = Math.max(ans, mx);
        }
        return ans;
    }
}