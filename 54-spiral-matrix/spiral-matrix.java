class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ls = new ArrayList<>();
        int m = matrix.length;
        int n = matrix[0].length;
        int top = 0 , bottom = m-1;
        int l = 0 , r = n-1 ;
        
        while(top <= bottom && l <= r) {
            for(int i=l ; i<=r ; i++) {
                ls.add(matrix[top][i]);
            }
            top++;

            for(int j=top; j<=bottom; j++) {
                ls.add(matrix[j][r]);
            }
            r--;

            if(top<=bottom) {
                for(int i=r; i>=l; i--) {
                    ls.add(matrix[bottom][i]);
                }
                bottom--;
            }
            if(l<=r) {
                for(int j=bottom; j>=top; j--) {
                    ls.add(matrix[j][l]);
                }
                l++;
            }
        }
        return ls;
    }
}