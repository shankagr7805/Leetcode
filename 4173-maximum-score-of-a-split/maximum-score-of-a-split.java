class Solution {
    public long maximumScore(int[] nums) {
        int n = nums.length;
        long[] prefix = new long[n];
        int[] suff = new int[n];
        prefix[0] = nums[0];
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] + nums[i];
        }

        suff[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            suff[i] = Math.min(nums[i], suff[i + 1]);
        }

        long max_score = Integer.MIN_VALUE;
        for (int i = 0; i < n - 1; i++) {
            long score = prefix[i] - suff[i + 1];
            max_score = Math.max(max_score, score);
        }
        return max_score;
    }
}