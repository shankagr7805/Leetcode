class Solution {
    private boolean same(HashMap<Character, Integer> mp, HashMap<Character, Integer> t_mp) {
        boolean isSame = true;

        for (Map.Entry<Character, Integer> entry : t_mp.entrySet()) {
            char key = entry.getKey();
            int val = entry.getValue();

            if (!mp.containsKey(key) || mp.get(key)<val) {
                isSame = false;
                break;
            }
        }
        return isSame;
    }

    public String minWindow(String s, String t) {
        int l=0, r=0, min_len = Integer.MAX_VALUE , start = 0;
        HashMap<Character, Integer> mp = new HashMap<>();
        HashMap<Character, Integer> t_mp = new HashMap<>();

        for(char c : t.toCharArray()) {
            t_mp.put(c , t_mp.getOrDefault(c , 0) + 1);
        }
        while(r < s.length()) {
            mp.put(s.charAt(r) , mp.getOrDefault(s.charAt(r) , 0) + 1);

            while(same(mp , t_mp)) {
                if (r - l + 1 < min_len) {
                    min_len = r - l + 1;
                    start = l;
                }
                mp.put(s.charAt(l), mp.get(s.charAt(l)) - 1);
                if (mp.get(s.charAt(l)) == 0)
                    mp.remove(s.charAt(l));
                l++;
            }
            r++;
        }
        return min_len == Integer.MAX_VALUE ? "" : s.substring(start, start + min_len);
    }
}