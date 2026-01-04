class Solution {
    public long removeZeros(long n) {
        long ans = 0;
        long ten = 1;
        while (n > 0) {
            long r = (n%10);
            if (r != 0) {
                ans = ans + ten*r;
                ten = (ten*10);
            }
            n = n/10;
        }
        return ans;
    }
}