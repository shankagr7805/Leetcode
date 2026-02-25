class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int mp = prices[0];
        int p = 0;

        for(int i=1; i<n; i++) {
            p = Math.max(prices[i]-mp , p);
            mp = Math.min(mp, prices[i]);
        }
        return p;
    }
}