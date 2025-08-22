class Solution {
    public int minimumArea(int[][] grid) {
        boolean has_1 = false;
        int mnm_r = grid[0].length; int mxm_r = -1; 
        int mnm_c = grid.length; int mxm_c = -1;
        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[0].length; j++) {
                if(grid[i][j] == 1) {
                    has_1 = true;
                    mnm_r = Math.min(mnm_r , i);
                    mxm_r = Math.max(mxm_r , i);
                    mnm_c = Math.min(mnm_c , j);
                    mxm_c = Math.max(mxm_c , j);
                }
            }
        }
        if(!has_1) return 0;
        int len = mxm_c - mnm_c + 1 ;
        int wid = mxm_r - mnm_r + 1 ;

        return len * wid ;
    }
}