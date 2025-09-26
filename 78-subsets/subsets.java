class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        for (int d = 0; d < (1 << n); d++) {
            List<Integer> s = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                if ((d & (1 << i)) != 0)
                    s.add(nums[i]);
            }
            ans.add(s);
        }
        return ans;
    }
}