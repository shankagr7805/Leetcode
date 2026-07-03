class Solution {
    public int findParent(int node, int[]parent){
        if(parent[node]==node){
            return node;
        }
        parent[node]= findParent(parent[node],parent);
        return parent[node];
    }

    public void union_rank(int u,int v,int[] rank,int[] parent){
        int pu = findParent(u,parent);
        int pv = findParent(v,parent);
        if(pu == pv) return;
        if(rank[pu]<rank[pv]){
            parent[pu]=pv;
        }else if(rank[pv]<rank[pu]){
            parent[pv]=pu;
        }else{
            parent[pv]=pu;
            rank[pu]++;
        }
    }

    public int removeStones(int[][] stones) {
        int maxRow = 0;
        int maxCol = 0;
        for(int i=0; i<stones.length; i++) {
            maxRow = Math.max(maxRow, stones[i][0]);
            maxCol = Math.max(maxCol, stones[i][1]);
        }

        int size = maxRow + maxCol + 2;
        int[] parent = new int[size];
        int[] rank = new int[size];
        for(int i =0; i<size;i++){
            parent[i]=i;
        }
        
        HashMap<Integer, Integer> mp = new HashMap<>();
        for(int[] edge: stones){
            int nodeRow = edge[0];
            int nodeCol = edge[1] + maxRow + 1;
            union_rank(nodeRow, nodeCol, rank, parent);   
            mp.put(nodeRow, 1);
            mp.put(nodeCol, 1);
        }
        int cnt = 0;
        for(int node : mp.keySet()) {
            if(findParent(node, parent) == node) cnt++;
        }
        return  stones.length - cnt;
    }
}