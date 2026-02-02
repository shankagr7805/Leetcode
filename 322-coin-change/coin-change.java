class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length; int t = amount;
        int[] prev = new int[t+1];
        for(int j=0; j<t+1; j++) {
            if(j % coins[0] == 0) prev[j] = j/coins[0];
            else prev[j] = (int)1e9;
        }
        
        for(int i=1; i<n; i++) {
            int[] curr = new int[t+1];
            for(int j=0; j<=t; j++) {
                int notTake = prev[j];
                int take = Integer.MAX_VALUE;
                if(coins[i] <= j) {
                    take = 1 + curr[j-coins[i]];
                }
                curr[j] = Math.min(take, notTake);
            }
            prev = curr;
        }
        int ans = prev[t];
        if(ans >= 1e9) return -1;
        return ans;
    }
}