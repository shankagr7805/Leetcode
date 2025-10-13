class Solution {
    public int lengthOfLastWord(String s) {
        s = s.trim();
        int l=0; int r=0;

        while(r<s.length()) {
            while(r<s.length()-1 && s.charAt(r) == ' ') {
                r++;
                l = r;
            }
            r++;
        }
        return r-l;
    }
}