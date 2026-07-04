class DisjointSet {
    List<Integer> parent = new ArrayList<>();
    List<Integer> size = new ArrayList<>();
    public DisjointSet(int n) {
        for(int i=0; i<=n; i++) {
            parent.add(i);
            size.add(1);
        }
    }
    public int findUlP(int node) {
        if(node == parent.get(node)) return node;
        int ulp = findUlP(parent.get(node));
        parent.set(node, ulp);
        return parent.get(node);
    }
    public void unionBySize(int u, int v) {
        int ulp_u = findUlP(u);
        int ulp_v = findUlP(v);
        if(ulp_u == ulp_v) return;

        if(size.get(ulp_u) < size.get(ulp_v)) {
            parent.set(ulp_u, ulp_v);
            size.set(ulp_v , size.get(ulp_u) + size.get(ulp_v));
        } else {
            parent.set(ulp_v, ulp_u);
            size.set(ulp_u , size.get(ulp_u) + size.get(ulp_v));
        }
    }
}
class Solution {
    private boolean isValid(int r, int c, int n) {
        return r>=0 && r<n && c>=0 && c<n;
    }
    public int largestIsland(int[][] grid) {
        int n = grid.length;
        DisjointSet ds = new DisjointSet(n*n);
        for(int row=0; row<n; row++) {
            for(int col=0; col<n; col++) {
                if(grid[row][col]==0) continue;
                int[] dr = {-1, 0, 1, 0};
                int[] dc = {0, 1, 0, -1};
                for(int ind=0; ind<4; ind++) {
                    int newr = row + dr[ind];
                    int newc = col + dc[ind];
                    if(isValid(newr, newc, n) && grid[newr][newc] == 1) {
                        int no = row * n + col;
                        int adjNo = newr * n + newc;
                        ds.unionBySize(no, adjNo);
                    }
                }
            }
        }
        int mx = 0;
        for(int row=0; row<n; row++) {
            for(int col=0; col<n; col++) {
                if(grid[row][col]==1) continue;
                int[] dr = {-1, 0, 1, 0};
                int[] dc = {0, 1, 0, -1};
                HashSet<Integer> c = new HashSet<>();
                for(int ind=0; ind<4; ind++) {
                    int newr = row + dr[ind];
                    int newc = col + dc[ind];
                    if(isValid(newr, newc, n) && grid[newr][newc] == 1) {
                        c.add(ds.findUlP(newr * n + newc));
                    }
                }
                int totalSize = 0;
                for(Integer parents : c) {
                    totalSize += ds.size.get(parents);
                }
                mx = Math.max(mx, totalSize+1);
            }
        }
        for(int cell=0; cell<n*n; cell++) {
            mx = Math.max(mx, ds.size.get(ds.findUlP(cell)));
        }
        return mx;
    }
}