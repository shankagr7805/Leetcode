class Solution {
public:
    int numWaterBottles(int n, int x) {
        int ans = n; int empty = n ;
        while(empty >= x) {
            int nb = empty / x ;
            ans += nb ;
            empty = nb + (empty % x) ;
        }
        return ans ;
    }     
};