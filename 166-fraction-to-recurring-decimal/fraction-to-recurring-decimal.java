class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) return "0";

        StringBuilder ans = new StringBuilder();

        long num = numerator;
        long den = denominator;

        // handle sign
        if ((num < 0) ^ (den < 0)) ans.append("-");
        num = Math.abs(num);
        den = Math.abs(den);

        // integer part
        ans.append(num / den);
        long rem = num % den;

        // no decimal part
        if (rem == 0) return ans.toString();

        ans.append(".");

        // remainder -> position in ans
        Map<Long, Integer> seen = new HashMap<>();

        while (rem != 0) {
            if (seen.containsKey(rem)) {
                int idx = seen.get(rem);
                ans.insert(idx, "(");
                ans.append(")");
                break;
            }

            seen.put(rem, ans.length());

            rem *= 10;
            ans.append(rem / den);
            rem %= den;
        }

        return ans.toString();
    }
}