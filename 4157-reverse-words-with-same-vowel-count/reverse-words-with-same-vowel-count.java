class Solution {
    private int vowel_count(String a) {
        int cnt = 0;
        for(char c : a.toCharArray()) {
            if(c=='a' || c=='e' || c=='i' || c=='o' || c=='u') {
                cnt++;
            }
        }
        return cnt;
    }
    public String reverseWords(String s) {
        List<String> ls = Arrays.asList(s.split(" "));
        int og_cnt = vowel_count(ls.get(0));

        StringBuilder sb = new StringBuilder();
        sb.append(ls.get(0));
        for(int i=1; i<ls.size(); i++) {
            if(vowel_count(ls.get(i)) == og_cnt) {
                sb.append(" ");
                sb.append(new StringBuilder(ls.get(i)).reverse());
            } else {
                sb.append(" ");
                sb.append(ls.get(i));
            }
        }

        return sb.toString();
    }
}