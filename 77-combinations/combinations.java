class Solution {
    private List<List<Integer>> ans = new ArrayList<>();
    private int k;
    private List<Integer> t = new ArrayList<>();

    private void dfs(int j, int n) {
        if (t.size() == k) {
            ans.add(new ArrayList<>(t));
            return;
        }
        for (int i = j; i <= n; i++) {
            t.add(i);
            dfs(i + 1, n);
            t.remove(t.size() - 1);
        }

    }
    public List<List<Integer>> combine(int n, int k) {
        this.k = k;
        
        dfs(1, n);
        return ans;
    }
}