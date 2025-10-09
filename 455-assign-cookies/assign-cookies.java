class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int l = 0, r = 0; 
        while(r < s.length) {
            if(l>=g.length) break;
            if(s[r] >= g[l]) {
                l++;
            } 
            r++;
        }
        return l;
    }
}