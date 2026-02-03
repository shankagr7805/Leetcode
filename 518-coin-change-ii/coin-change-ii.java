class Solution {
    public int change(int k, int[] coins) {
        int n = coins.length;
        int[] prev = new int[k+1];
    
        prev[0] = 1;

        for(int i=0; i<n; i++) {
            for(int j=coins[i]; j<=k; j++) {
                prev[j] += prev[j-coins[i]];
            }
        }
        return prev[k];
    }
}