class Solution {
    public int characterReplacement(String s, int k) {
        int[] mp = new int[26];
        int l = 0, r = 0, max_len = 0, cnt = 0;
        while (r < s.length()) {
            mp[s.charAt(r) - 'A']++;
            cnt = Math.max(cnt , mp[s.charAt(r) - 'A']);
            
            while(((r-l+1) - cnt) > k) {
                mp[s.charAt(l) - 'A']--;
                l++;
            }
            if((r-l+1) - cnt <= k) {
                max_len = Math.max(r-l+1 , max_len);
            }
            r++;
        }
        return max_len;
    }
}