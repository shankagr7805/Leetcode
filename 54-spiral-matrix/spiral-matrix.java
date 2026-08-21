class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        List<Integer> ls = new ArrayList<>();
        int i=0; int b=n-1;
        int l=0;
        int r = m-1;

        while(i<=b && l<=r) {
            for(int j=l; j<=r; j++) {
                ls.add(matrix[i][j]);
            }
            i++;
            for(int k=i; k<=b; k++) {
                ls.add(matrix[k][r]);
            }
            r--;
            if(i<=b) {
                for(int j=r; j>=l; j--) {
                    ls.add(matrix[b][j]);
                }
                b--;
            }
            if(l<=r) {
                for(int k=b; k>=i; k--) {
                    ls.add(matrix[k][l]);
                }
                l++;
            }
        }
        return ls;
    }
}