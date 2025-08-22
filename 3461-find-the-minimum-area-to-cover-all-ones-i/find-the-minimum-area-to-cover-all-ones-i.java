class Solution {
    public int minimumArea(int[][] grid) {
        boolean has_1 = false;
        int mnm_r = Integer.MAX_VALUE; int mxm_r = Integer.MIN_VALUE; 
        int mnm_c = Integer.MAX_VALUE; int mxm_c = Integer.MIN_VALUE;
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
        if(!has_1) return -1;
        int len = mxm_c - mnm_c + 1 ;
        int wid = mxm_r - mnm_r + 1 ;

        return len * wid ;
    }
}