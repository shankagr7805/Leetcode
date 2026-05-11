class Solution {
    public int minFlips(String s) {
        int n = s.length();
        int ones = 0;

        for(int i=0; i<n; i++) {
            if(s.charAt(i) == '1') ones++;
        }
        int zero = n - ones;
        int minF = Math.min(ones, zero);

        if(ones>0) minF = Math.min(minF, ones-1);

        if(n>=2) {
            int edgeF = (s.charAt(0) == '0' ? 1 : 0) + (s.charAt(n - 1) == '0' ? 1 : 0);
            int mid = ones - (s.charAt(0) == '1' ? 1 : 0) - (s.charAt(n - 1) == '1' ? 1 : 0);
            minF = Math.min(minF, edgeF+mid);
        }
        return minF;
    }
}