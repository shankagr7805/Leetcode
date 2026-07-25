class Solution {
    public int climbStairs(int n) {
        int prev2 = 1;
        int prev = 1;
        while(n >= 2) {
            int curr = prev + prev2;
            prev2 = prev;
            prev = curr;
            n--;
        }
        return prev;
    }
}