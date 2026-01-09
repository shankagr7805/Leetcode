class Solution {
    public String toHex(int num) {
        if (num == 0) return "0";

        char[] hex = "0123456789abcdef".toCharArray();
        StringBuilder sb = new StringBuilder();

        // Process at most 8 hex digits (32 bits)
        for (int i = 0; i < 8 && num != 0; i++) {
            int digit = num & 15;     // last 4 bits
            sb.append(hex[digit]);
            num >>>= 4;               // unsigned shift
        }

        return sb.reverse().toString();
    }
}