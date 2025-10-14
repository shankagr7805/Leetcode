class Solution {
    public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
        int n = nums.size();
        if (n < 2 * k) return false; 
        for (int i = 0; i + 2 * k <= n; i++) {
            boolean f = true, s = true;

            for (int j = i; j < i + k - 1; j++) {
                if (nums.get(j) >= nums.get(j + 1)) {
                    f = false;
                    break;
                }
            }
            for (int j = i + k; j < i + 2 * k - 1; j++) {
                if (nums.get(j) >= nums.get(j + 1)) {
                    s = false;
                    break;
                }
            }

            if (f && s) return true;
        }

        return false;
    }
}