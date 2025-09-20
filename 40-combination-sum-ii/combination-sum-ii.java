class Solution {
    private void single(List<List<Integer>> ans, List<Integer> s, int[] candidates, int target, int idx) {
        if (target < 0)
            return;
        if (target == 0) {
            ans.add(new ArrayList<>(s));
            return;
        }

        for (int i = idx; i < candidates.length; i++) {

            if(i>idx && candidates[i] == candidates[i-1]) continue ;
            if(candidates[i] > target) break;;

            s.add(candidates[i]);
            single(ans, s, candidates, target - candidates[i], i + 1);
            s.remove(s.size() - 1);
        }
        return;
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans = new ArrayList<>();
        single(ans, new ArrayList<>(), candidates, target, 0);

        return ans;
    }
}