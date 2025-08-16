class Solution {
    public int myAtoi(String s) {
        if (s == null || s.isEmpty())
            return 0;

        s = s.trim();
        if (s.isEmpty())
            return 0;

        boolean neg = false;
        int i = 0;
        if (s.charAt(0) == '-') {
            neg = true;
            i++;
        } else if (s.charAt(0) == '+') {
            i++;
        }

        while (i < s.length() && s.charAt(i) == '0') {
            i++;
        }

        int idx = i;

        while (idx < s.length() && Character.isDigit(s.charAt(idx))) {
            idx++;
        }

        if (idx == i)
            return 0;

        String num = s.substring(i, idx);
        long ans = 0;

        for (char c : num.toCharArray()) {
            ans = ans * 10 + (c - '0');
            if (!neg && ans > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }
            if (neg && -ans < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }
        }
        return (neg) ? (int) -ans : (int) ans;
    }
}