class Solution {
    public int maxScore(int[] c, int k) {
        int n = c.length;
        int ls = 0, rs = 0, max_sum = 0;
        for(int i=0; i<k; i++) ls += c[i];
        max_sum = ls;
        for(int i=k-1; i>=0; i--) {
            ls -= c[i];
            rs += c[n-1];
            max_sum = Math.max(max_sum , ls+rs) ;
            n--;
        }
        return max_sum ;
    }
}