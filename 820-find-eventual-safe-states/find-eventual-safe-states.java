class Solution {
    private boolean dfs(int node, int[] vis , int[] path, int[] check, int[][] graph) {
        vis[node] = 1;
        path[node] = 1;
        check[node] = 0;

        for (int it : graph[node]) {
            if (vis[it] == 0) {
                if (dfs(it, vis, path, check, graph)) return true;
            } else if (path[it] == 1) {
                return true;
            }
        }
        check[node] = 1;
        path[node] = 0;
        return false;
    }
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        int m = graph[0].length;
        List<Integer> ans = new ArrayList<>();
        int[] vis = new int[n];
        int[] path = new int[n];
        int[] check = new int[n];

        for(int i=0; i<n; i++) {
            if(vis[i] == 0) {
                dfs(i, vis, path, check, graph);
            }
        }
        for(int i=0; i<n; i++) {
            if(check[i] == 1) ans.add(i);
        }
        return ans;
    }
}