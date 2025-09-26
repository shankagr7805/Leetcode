class Solution {
    public int divide(int dividend, int divisor) {
        if (dividend == divisor)
            return 1;
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }    
        boolean s = true;
        if (dividend <= 0 && divisor > 0)
            s = false;
        else if (dividend >= 0 && divisor < 0)
            s = false;
        long n = Math.abs((long) dividend);
        long d = Math.abs((long) divisor);
        long ans = 0;
        while (n >= d) {
            long cnt = 0;
            while (n >= (d << (cnt + 1))) {
                cnt += 1;
            }
            ans += 1 << cnt;
            n -= (d << cnt);
        }

        if (ans == (1L << 31) && s)
            return Integer.MAX_VALUE;
        if (ans == (1L << 31) && !s)
            return Integer.MIN_VALUE;

        return s ? (int) ans : (int) -ans;
    }
}