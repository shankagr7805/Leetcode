class Solution {
    public String minWindow(String s, String t) {
        int l=0, r=0, min_len = Integer.MAX_VALUE , start = 0 , cnt = 0;
        int[] f = new int[256];
        for(int i=0; i<t.length(); i++) {
            f[t.charAt(i)]++;
        }
        while(r < s.length()) {  
            if(f[s.charAt(r)] > 0) cnt++;
            f[s.charAt(r)]--;
            
            while(cnt == t.length()) {
                if(r-l+1 < min_len) {
                    min_len = r-l+1;
                    start = l;
                } 
                f[s.charAt(l)]++;
                if(f[s.charAt(l)] > 0) cnt--;
                l++;       
            } 
            r++;
        }
        return min_len == Integer.MAX_VALUE ? "" : s.substring(start, start + min_len);
    }
}