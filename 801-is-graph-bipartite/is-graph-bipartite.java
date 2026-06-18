class Solution {
    private boolean dfs(int i, int col, int color[], int graph[][]) {
        color[i] = col;

        for(int it : graph[i]) {
            if(color[it] == -1) {
                if(dfs(it, 1-col, color, graph) == false) return false;
            } else if(color[it] == col) {
                return false;
            }
        }
        return true;
    }
    public boolean isBipartite(int[][] graph) {
        List<List<Integer>> adj = new ArrayList<>();
        int[] color = new int[graph.length];
        for(int i=0; i<color.length; i++) color[i] = -1;

        for(int i=0; i<graph.length; i++) {
            if(color[i] == -1) {
                if(dfs(i, 0, color, graph) == false) return false;
            }
        }

        return true;
    }
}