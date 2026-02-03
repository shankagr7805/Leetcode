class Solution {
    public int change(int k, int[] coins) {
        int n = coins.length;
        int[] prev = new int[k+1];
        for(int j=0; j<k+1; j++) {
            if(j % coins[0] == 0) {
                prev[j] = 1;
            } else {
                prev[j] = 0;
            }
        }

        for(int i=1; i<n; i++) {
            int[] curr = new int[k+1];
            for(int j=0; j<=k; j++) {
                int notTake = prev[j];
                int take = 0;
                if(coins[i] <= j) {
                    take = curr[j-coins[i]];
                }
                curr[j] = take + notTake;
            }
            prev = curr;
        }

        return prev[k];
    }
}