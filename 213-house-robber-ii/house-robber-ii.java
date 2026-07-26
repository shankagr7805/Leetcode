class Solution {
    private int rob_adj(int[] nums, int start, int end) {
        int prev = 0; int prev2 = 0;

        for(int i=start; i<=end; i++) {
            int take = prev2 + nums[i];
            int not = prev;

            int curr = Math.max(take, not);
            prev2 = prev;
            prev = curr;
        }
        return prev;
    }
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];

        int a = rob_adj(nums, 0, n-2);
        int b = rob_adj(nums, 1, n-1);

        return Math.max(a, b);
    }
} 