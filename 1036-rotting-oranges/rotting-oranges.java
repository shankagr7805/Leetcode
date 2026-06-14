class Pair {
    int a;
    int b;
    int t;

    Pair(int _a, int _b, int _t) {
        this.a = _a; this.b = _b; this.t = _t;
    }
}
class Solution {
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        Queue<Pair> q = new LinkedList<Pair>(); 
        int[][] vis = new int[n][m];
        int fresh = 0;

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(grid[i][j] == 2) {
                    q.add(new Pair(i,j,0));
                    vis[i][j] = 2;
                } else {
                    vis[i][j] = 0;
                }
                if(grid[i][j] == 1) fresh++;
            }
        }
        int t = 0;
        int row[] = {-1, 0, 1, 0};
        int col[] = {0, 1, 0, -1};
        int cnt = 0;

        while(!q.isEmpty()) {
            int r = q.peek().a;
            int c = q.peek().b;
            int time = q.peek().t;

            t = Math.max(t, time);
            q.remove();
            for(int i=0; i<4; i++) {
                int nrow = r + row[i];
                int ncol = c + col[i];
                if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && vis[nrow][ncol] == 0 && grid[nrow][ncol] == 1) {
                    q.add(new Pair(nrow, ncol, time+1));
                    vis[nrow][ncol] = 2;
                    cnt++;
                }
            }
        }
        if(cnt != fresh) return -1;
        return t;
    }
}