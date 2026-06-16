class Solution {
    private int dr[] = {-1, 0, 1, 0};
    private int dc[] = {0, 1, 0, -1};
    private void dfs(int i, int j, char[][] board, boolean[][] vis) {
        int n = board.length;
        int m = board[0].length; 
        vis[i][j] = true;
        for(int k=0; k<4; k++) {
            int nr = i+dr[k]; int nc = j+dc[k];
            if(nr>=0 && nr<n && nc>=0 && nc<m && board[nr][nc]=='O' && !vis[nr][nc]) {
                dfs(nr, nc, board, vis);
            }
        }
        return;
    }
    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        boolean[][] vis = new boolean[n][m];
        for(int i=0; i<n; i++) {
            if(board[i][0]=='O' && !vis[i][0]) {
                dfs(i, 0, board, vis);
            }
            if(board[i][m-1]=='O' && !vis[i][m-1]) {
                dfs(i, m-1, board, vis);
            }
        }
        for(int j=0; j<m; j++) {
            if(board[0][j]=='O' && !vis[0][j]) {
                dfs(0, j, board, vis);
            }
            if(board[n-1][j]=='O' && !vis[n-1][j]) {
                dfs(n-1, j, board, vis);
            }
        }

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(vis[i][j]) board[i][j] = 'O';
                else board[i][j] = 'X';
            }
        }
    }
}