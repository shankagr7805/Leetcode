class Solution {
    private int lcs(String s, String t) {
        int n = s.length();
        int[] prev = new int[n+1];
        for(int i=1; i<=n; i++) {
            int[] curr = new int[n+1];
            for(int j=1; j<=n; j++) {
                if(s.charAt(i-1) == t.charAt(j-1)) {
                    curr[j] = prev[j-1] + 1;
                } else {
                    curr[j] = Math.max(curr[j-1], prev[j]);
                }
            }
            prev = curr;
        }
        return prev[n];
    }
    public int minInsertions(String s) {
        int n = s.length();
        StringBuilder sb = new StringBuilder();

        for(int i=n-1; i>=0; i--) {
            sb.append(s.charAt(i));
        }
        String t = sb.toString();
        int ans = lcs(s , t);
        return (n-ans);
    }
}