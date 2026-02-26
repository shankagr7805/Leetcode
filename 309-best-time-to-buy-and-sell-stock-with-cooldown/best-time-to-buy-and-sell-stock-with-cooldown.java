class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[] after1 = new int[2];
        int[] after2 = new int[2];
        int[] curr = new int[2];
        for(int i=n-1; i>=0; i--) {
            for(int j=0; j<2; j++) {
                if(j == 1) {
                    curr[j] = Math.max(-prices[i] + after1[0] , after1[1]);
                } else {
                    curr[j] = Math.max(prices[i] + after2[1] , after1[0]);
                }
            }
            System.arraycopy(after1, 0, after2, 0, 2);
            System.arraycopy(curr, 0, after1, 0, 2);
        }
        return curr[1];
    }
}