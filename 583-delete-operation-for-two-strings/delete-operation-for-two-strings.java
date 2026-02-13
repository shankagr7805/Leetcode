class Solution {
    private int lcs(String s , String t) {
        int n1 = s.length(); int n2 = t.length();
        int[] prev = new int[n2+1];
        for(int i=1; i<=n1; i++) {
            int[] curr = new int[n2+1];
            for(int j=1; j<=n2; j++) {
                if(s.charAt(i-1) == t.charAt(j-1)) {
                    curr[j] = prev[j-1] + 1;
                } else {
                    curr[j] = Math.max(curr[j-1], prev[j]);
                }
            }
            prev = curr;
        }
        return prev[n2];
    }
    public int minDistance(String word1, String word2) {
        int n1 = word1.length();
        int n2 = word2.length();
        int a = lcs(word1, word2);
        int ans = n1 - a + n2 - a;
        return ans;
    }
}