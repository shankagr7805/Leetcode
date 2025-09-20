class Solution {
    private void single(List<List<Integer>> ans, List<Integer> s, int[] candidates, int target, int sum, int idx) {
        if (sum == target) {
            ans.add(new ArrayList<>(s));
            return;
        }

        if (sum > target || idx == candidates.length) {
            return;
        }

        s.add(candidates[idx]);
        sum += candidates[idx];
        single(ans, s, candidates, target, sum, idx);
        s.remove(s.size() - 1);
        sum -= candidates[idx];

        single(ans, s, candidates, target, sum, idx + 1);

        return;
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        single(ans, new ArrayList<>(), candidates, target, 0, 0);

        return ans;
    }
}