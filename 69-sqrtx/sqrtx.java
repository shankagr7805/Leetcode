class Solution {
    public int mySqrt(int x) {
        if(x < 2) return x ;
        int l = 1 ; int r = x / 2;
        int ans = 0;
        
        while(l<=r) {
            int mid = l + (r - l) / 2 ;
            long s = (long) mid * mid ;

            if(s == x) return mid ;
            if(s < x) {
                ans = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return ans ;
    }
}