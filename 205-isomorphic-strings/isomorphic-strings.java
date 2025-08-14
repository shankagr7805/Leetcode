class Solution {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> mp = new HashMap<>();

        for(int i=0; i<s.length(); i++) {
            if(!mp.containsKey(s.charAt(i))) {
                if(mp.containsValue(t.charAt(i))) {
                    return false;
                }
                mp.put(s.charAt(i) , t.charAt(i));
            } else {
                if(mp.get(s.charAt(i)) != t.charAt(i)) {
                    return false;
                } 
            }
        }
        return true;
    }
}