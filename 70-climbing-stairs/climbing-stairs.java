class Solution {
    public int climbStairs(int n) {
        // Similar to Fibonacci series problem
        if(n<=2) return n;
        int a = 1;
        int b = 2;
        int sum = 0;
        for(int i=3; i<=n; i++) {
            sum = a + b;
            a = b;
            b = sum;
        }

        return sum;
    }
}