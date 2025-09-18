class Solution {
    private long MOD = 1000000007;

    private long power(long x , long n) {
        if(n==0) return 1;
        long temp = power(x , n/2);

        if(n % 2 == 0) {
            return (temp * temp) % MOD ;
        } else {
            return (x * temp * temp) % MOD ;
        }
    }
    public int countGoodNumbers(long n) {
        long even = (n+1)/2 ;
        long odd = n/2 ;
        long first = power(5 , even)% MOD;
        long second = power(4 , odd) % MOD;
        return (int) ((first * second) % MOD) ;
    }
}