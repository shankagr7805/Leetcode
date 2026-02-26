class Solution {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int[] after = new int[2];
        int[] curr = new int[2];
        for(int i=n-1; i>=0; i--) {
            for(int j=0; j<2; j++) {
                curr[1] = Math.max(-prices[i] + after[0] , after[1]);
                curr[0] = Math.max(prices[i] + after[1] - fee , after[0]);
            }
            System.arraycopy(curr, 0, after, 0, 2);
        }
        return curr[1];
    }
}