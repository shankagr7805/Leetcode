class Tuple {
    int a, b, c;
    Tuple(int _a, int _b, int _c) {
        this.a = _a; this.b = _b; this.c = _c;
    }
}
class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if(n == 1) return grid[0][0] == 0 ? 1 : -1;
        if(grid[0][0] != 0 || grid[n-1][n-1] != 0) return -1;
        Queue<Tuple> q = new LinkedList<>();
        int[][] dis = new int[n][n];
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                dis[i][j] = (int) (1e9);
            }
        }
        dis[0][0] = 1;
        q.add(new Tuple(1, 0, 0));
        int[] dr = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] dc = {-1, 0, 1, -1, 1, -1, 0, 1};

        while(!q.isEmpty()) {
            Tuple it = q.peek();
            q.remove();
            int d = it.a;
            int r = it.b;
            int c = it.c;

            for(int i=0; i<8; i++) {
                int newr = r + dr[i];
                int newc = c + dc[i];

                if(newr>=0 && newr<n && newc>=0 && newc<n && grid[newr][newc] == 0 && d+1 < dis[newr][newc]) {
                    dis[newr][newc] = 1 + d;
                    if(newr == n-1 && newc == n-1) return 1 + d;
                    q.add(new Tuple(1 + d, newr, newc));
                }
            }
        }
        return -1;
    }
}