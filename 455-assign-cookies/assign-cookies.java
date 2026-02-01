class Solution {
    public int findContentChildren(int[] g, int[] s) {
        int i = 0; int j=0;
        int m = g.length; int n = s.length;
        Arrays.sort(g);
        Arrays.sort(s);
        int cnt = 0;
        while(i != m && j != n) {
            if(g[i] <= s[j]) {
                i++;
                j++;
                cnt++;
            } else {
                j++;
            }
        }
        return cnt;
    }
}