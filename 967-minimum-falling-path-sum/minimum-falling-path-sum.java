class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[] prev = new int[n];
        for(int i=0; i<n; i++) prev[i] = matrix[0][i];

        for(int i=1; i<m; i++) {
            int[] curr = new int[n];
            for(int j=0; j<n; j++) {
                if(j==0) {
                    curr[j] = Math.min(prev[j] , prev[j+1]) + matrix[i][j];
                } else if(j==n-1) {
                    curr[j] = Math.min(prev[j] , prev[j-1]) + matrix[i][j];
                } else {
                   curr[j] = Math.min(prev[j], Math.min(prev[j-1] , prev[j+1])) + matrix[i][j];
                }
            } 
            prev = curr;
        }
        int mnm = Integer.MAX_VALUE;
        for(int i=0; i<n; i++) {
            mnm = Math.min(mnm, prev[i]);
        }
        return mnm;
    }
}