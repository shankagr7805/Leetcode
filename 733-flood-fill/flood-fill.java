class Solution {
    private void dfs(int r, int c, int[][] ans, int[][] image, int color, int[] dr, int[] dc, int in) {
        ans[r][c] = color;
        int n = image.length;
        int m = image[0].length;
        for(int i=0; i<4; i++) {
            int nrow = r + dr[i];
            int ncol = c + dc[i];

            if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && image[nrow][ncol] == in && ans[nrow][ncol] != color) {
                dfs(nrow, ncol, ans, image, color, dr, dc, in);
            }
        }
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int in = image[sr][sc];
        int[][] ans = image;
        int dr[] = {-1, 0, 1, 0};
        int dc[] = {0, 1, 0, -1};
        dfs(sr, sc, ans, image, color, dr, dc, in);
        return ans;
    }
}