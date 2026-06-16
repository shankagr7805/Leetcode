class Solution {
    private int dr[] = {-1, 0, 1, 0};
    private int dc[] = {0, 1, 0, -1};
    private void dfs(int i, int j, int[][] grid, boolean[][] vis) {
        vis[i][j] = true;
        int n = grid.length;
        int m = grid[0].length;
        for(int k=0; k<4; k++) {
            int nr = i+dr[k]; int nc = j+dc[k];
            if(nr>=0 && nr<n && nc>=0 && nc<m && !vis[nr][nc] && grid[nr][nc] == 1) {
                dfs(nr, nc, grid, vis);
            }
        }
    }
    public int numEnclaves(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] vis = new boolean[n][m];

        for(int i=0; i<n; i++) {
            if(grid[i][0] == 1 && !vis[i][0]) dfs(i, 0, grid, vis);
            if(grid[i][m-1] == 1 && !vis[i][m-1]) dfs(i, m-1, grid, vis);
        }
        for(int j=0; j<m; j++) {
            if(grid[0][j] == 1 && !vis[0][j]) dfs(0, j, grid, vis);
            if(grid[n-1][j] == 1 && !vis[n-1][j]) dfs(n-1, j, grid, vis);
        }

        int cnt = 0; int c_vis = 0;
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(grid[i][j] == 1) cnt++;
                if(vis[i][j]) c_vis++;
            }
        }

        return cnt-c_vis;
    }
}