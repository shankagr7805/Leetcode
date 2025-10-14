class Solution {
    public int reverseBits(int n) {
        String str = String.format("%32s", Integer.toBinaryString(n)).replace(' ', '0');
        StringBuilder sb = new StringBuilder(str);
        sb.reverse();
        String s = sb.toString();

        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            ans = ans * 2 + (s.charAt(i) - '0');
        }
        return ans;
    }
}