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

    public int makeConnected(int n, int[][] connections) {
        int[] parent = new int[n];
        int[] rank = new int[n];
        for(int i =0; i<n;i++){
            parent[i]=i;
            rank[i]=0;
        }

        if(connections.length < n-1) return -1;

        for(int[] edge: connections){
            int u = edge[0];
            int v = edge[1];
            union_rank(u, v,rank,parent);   
        }
        int component=0;
        for(int i =0; i<n;i++){
            if(parent[i]==i ) component++;
        }
        return component-1;
    }
}