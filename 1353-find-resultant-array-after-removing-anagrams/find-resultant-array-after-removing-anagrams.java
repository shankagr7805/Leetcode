class Solution {
    private int[] getFreq(String word) {
        int[] f = new int[26];
        for (char c : word.toCharArray()) {
            f[c - 'a']++;
        }
        return f;
    }
    public List<String> removeAnagrams(String[] words) {
        List<String> s = new ArrayList<>();
        boolean prev = false;
        int[] prevCount = new int[26];

        for(String word : words) {
            int[] cnt = getFreq(word);

            if(prev && Arrays.equals(prevCount , cnt)) continue;

            s.add(word);
            prevCount = cnt;
            prev = true;
        }
        return s ;
    }
}