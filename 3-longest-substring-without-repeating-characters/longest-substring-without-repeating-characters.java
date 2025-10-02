class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        if(n==0) return 0;

        Set<Character> sb = new HashSet<>();
        int l = 0; int r = 0; int mx = 1;

        while(r < n) {
            if(!sb.contains(s.charAt(r))) {
                sb.add(s.charAt(r)); 
                mx = Math.max(mx , r-l+1);
                r++;
            } else {
                sb.remove(s.charAt(l));
                l++;
            }
        }
        return mx ;
    }
}