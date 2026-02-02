class Solution {
    private int f(int idx, int k, int[] nums) {
        int n = nums.length; int cnt = 0; int sum = 0;
        if(idx == n) {
            return k == 0 ? 1 : 0;
        }
        int plus = f(idx + 1, k - nums[idx], nums);
        int minus = f(idx + 1, k + nums[idx], nums);

        return plus + minus;
    }
    public int findTargetSumWays(int[] nums, int target) {
        return f(0, target, nums);
    }
}