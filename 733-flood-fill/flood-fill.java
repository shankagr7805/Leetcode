class Solution {
    private void dfs(int r, int c, int[][] image, int color, int[] dr, int[] dc, int initial) {
        if (r < 0 || r >= image.length || c < 0 || c >= image[0].length || image[r][c] != initial) {
            return;
        }
        image[r][c] = color;

        dfs(r + 1, c, image, color, dr, dc, initial); 
        dfs(r - 1, c, image, color, dr, dc, initial); 
        dfs(r, c + 1, image, color, dr, dc, initial); 
        dfs(r, c - 1, image, color, dr, dc, initial); 
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