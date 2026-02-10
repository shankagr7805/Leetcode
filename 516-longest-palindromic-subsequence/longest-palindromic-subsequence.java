class Solution {
    public int lcs( String s, String t) {
        int n1 = s.length();
        int n2 = t.length();
        int[] prev = new int[n2+1];
        for(int i=1; i<=n1; i++) {
            int[] curr = new int[n2+1];
            for(int j=1; j<=n2; j++) {
                if(t.charAt(j-1) == s.charAt(i-1)) {
                    curr[j] = prev[j-1] + 1;
                } else {
                    curr[j] = Math.max(curr[j-1], prev[j]);
                }
            }
            prev = curr;
        }
        return prev[n2];
    }
    public int longestPalindromeSubseq(String s) {
        StringBuilder sb = new StringBuilder();
        for(int i=s.length()-1; i>=0; i--) {
            sb.append(s.charAt(i));
        }
        String t = sb.toString();
        return lcs(s, t);
    }
}