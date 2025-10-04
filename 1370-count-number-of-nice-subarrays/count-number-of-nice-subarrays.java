class Solution {
    private int preNice(int[] nums, int k) {
        if (k < 0) return 0;
        int l = 0, r = 0, odd = 0, cnt = 0;

        while (r < nums.length) {
            if (nums[r] % 2 != 0) odd++;
            while (odd > k) {
                if (nums[l] % 2 != 0) odd--;
                l++;
            }
            cnt = cnt + (r - l + 1);
            r++;
        }
        return cnt;
    }

    public int numberOfSubarrays(int[] nums, int k) {
        return preNice(nums, k) - preNice(nums, k - 1);
    }
}