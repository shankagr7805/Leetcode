class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        HashMap<Integer, Integer> mp = new HashMap<>();
        int count = 0;

        for(int j=0; j<n; j++) {
            for(int i=n-1; i>=0; i--) {
                mp.put(count , matrix[i][j]);
                count++;
            } 
        }
        int temp = 0;

        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                matrix[i][j] = mp.get(temp);
                temp++;
            }
        }

        return;
    }
}