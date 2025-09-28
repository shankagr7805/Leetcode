import java.util.Arrays;
class Solution {
    public int countPrimes(int n) {
        if (n <= 2) return 0;
        boolean[] p = new boolean[n];
        Arrays.fill(p , true);
        p[0] = false;
        p[1] = false;

        for (int i = 2; i * i < n; i++) {
            if (p[i]) {
                for (int j = i * i; j < n; j += i) {
                    p[j] = false;
                }
            }
        }
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (p[i]) count++;
        }
        return count;
    }
}