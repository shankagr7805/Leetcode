class Solution {
    public int reverseBits(int n) {
        int ans = 0;
        for (int i = 31; i >= 0; i--) {
            int bit = n & 1;
            ans |= (bit << i);
            n = n >> 1;        
        }
        return ans;
    }
}