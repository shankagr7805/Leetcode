class Solution {
    private void dfs(int node, List<List<Integer>> adj, boolean[] vis) {
        vis[node] = true;

        for (int nei : adj.get(node)) {
            if (!vis[nei]) {
                dfs(nei, adj, vis);
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
        List<Integer> dfs = new ArrayList<>();
        int n = isConnected.length;
        boolean[] vis = new boolean[n];

        if(n==0) return 0;

        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<n; i++) {
            adj.add(new ArrayList<Integer>());
        }

        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(isConnected[i][j] == 1 && i!=j) {
                    adj.get(i).add(j);
                    adj.get(j).add(i);
                }
            }
        }

        int cnt = 0;
        for(int i=0; i<n; i++) {
            if(vis[i] == false) {
                cnt++;
                dfs(i, adj, vis);
            }
        }
        return cnt;
    }
}