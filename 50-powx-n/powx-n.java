class Solution {
    private double power(double x, long n) {
        if(n == 0) {
          return 1;  
        } else if(n == 1) {
            return x;
        } else {
            double half = power(x , n/2);
            if(n % 2 == 0) {
                return half * half ;
            } else {
                return x * half * half ;
            }
        }
    }
    public double myPow(double x, long n) {
        if(n<0) {
            return 1 / (x * power(x, -(n + 1)));
        }
        
        return power(x , n) ;
    }
}