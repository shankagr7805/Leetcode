class Solution {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int a_buy=0, a_nbuy=0, c_buy=0, c_nbuy=0;
        for(int i=n-1; i>=0; i--) {
            c_buy = Math.max(-prices[i] + a_nbuy , a_buy);
            c_nbuy = Math.max(prices[i] + a_buy - fee , a_nbuy);

            a_buy = c_buy;
            a_nbuy = c_nbuy;
        }
        return a_buy;
    }
}