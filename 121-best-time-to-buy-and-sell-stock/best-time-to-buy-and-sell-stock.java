class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int mp = prices[0];
        int p = 0;

        for(int i=1; i<n; i++) {
            if(prices[i] < mp) {
                mp = prices[i];
            } else if(p < prices[i]-mp) {
                p = prices[i]-mp;
            }
        }
        return p;
    }
}