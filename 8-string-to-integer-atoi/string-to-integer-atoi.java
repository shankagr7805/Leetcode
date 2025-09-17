class Solution {
    private static final int INT_MAX = Integer.MAX_VALUE;
    private static final int INT_MIN = Integer.MIN_VALUE;

    public int myAtoi(String s) {
        if (s == null || s.isEmpty()) return 0;
        s = s.trim(); 
        if (s.isEmpty()) return 0;

        int sign = 1;
        int index = 0;

        if (s.charAt(0) == '-' || s.charAt(0) == '+') {
            sign = (s.charAt(0) == '-') ? -1 : 1;
            index++;
        }

        return recurse(s, index, 0L, sign); 
    }

    private int recurse(String s, int i, long num, int sign) {
        if (i >= s.length() || !Character.isDigit(s.charAt(i))) {
            long val = num * sign;
            if (val > INT_MAX) return INT_MAX;
            if (val < INT_MIN) return INT_MIN;
            return (int) val;
        }

        num = num * 10 + (s.charAt(i) - '0');

        if (sign == 1 && num > INT_MAX) return INT_MAX;
        if (sign == -1 && -num < INT_MIN) return INT_MIN;

        return recurse(s, i + 1, num, sign);
    }
}