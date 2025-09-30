class Solution {
    public double myPow(double x, long n) {
        double ans = 1.0;
        long s = n ;
        n = Math.abs(n) ;
        while(n > 0) {
            if(n % 2 == 0) {
                n = n / 2;
                x = x * x ;
            } else {
                ans = ans * x ;
                n = n - 1;
            }
        }
        if(s < 0) ans = 1.0 / ans ;
        return ans ;
    }
}