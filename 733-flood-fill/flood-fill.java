class Solution {
    private void dfs(int r, int c, int[][] image, int color, int[] dr, int[] dc, int initial) {
        image[r][c] = color;
        int n = image.length;
        int m = image[0].length;

        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];
            if (nr >= 0 && nr < n &&
                nc >= 0 && nc < m &&
                image[nr][nc] == initial) {

                dfs(nr, nc, image, color, dr, dc, initial);
            }
        }
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int initial = image[sr][sc];
        if (initial == color) return image;

        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};

        dfs(sr, sc, image, color, dr, dc, initial);

        return image;
    }
}