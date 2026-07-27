class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] prev = new int[n];
        Arrays.fill(prev, (int) 1e9);
        prev[0] = triangle.get(0).get(0);

        for(int i=1; i<n; i++) {
            int[] curr = new int[n];
            Arrays.fill(curr, (int) 1e9);
            curr[0] = prev[0] + triangle.get(i).get(0);
            for(int j=1; j<triangle.get(i).size(); j++) {
                curr[j] = Math.min(prev[j], prev[j-1]) + triangle.get(i).get(j);
            }
            prev = curr;
        }
        int mini = prev[0];
        for(int i=1; i<n; i++) {
            mini = Math.min(mini, prev[i]);
        }
        return mini;
    }
}