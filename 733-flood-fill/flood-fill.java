class Solution {
    private void dfs(int r, int c, int[][] image, int color, int initial) {
        if (r < 0 || r >= image.length || c < 0 || c >= image[0].length || image[r][c] != initial) {
            return;
        }
        image[r][c] = color;

        dfs(r + 1, c, image, color, initial); 
        dfs(r - 1, c, image, color, initial); 
        dfs(r, c + 1, image, color, initial); 
        dfs(r, c - 1, image, color, initial); 
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int initial = image[sr][sc];
        if (initial == color) return image;

        dfs(sr, sc, image, color, initial);

        return image;
    }
}