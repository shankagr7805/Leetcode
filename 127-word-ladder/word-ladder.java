class Pair {
    String a;
    int b;
    Pair(String _a, int _b) {
        this.a = _a;
        this.b = _b;
    }
}
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int n = beginWord.length();
        int m = wordList.size();

        Queue<Pair> q = new LinkedList<Pair>();
        q.add(new Pair(beginWord, 1));
        Set<String> st = new HashSet<String>();
        for(int i=0; i<m; i++) {
            st.add(wordList.get(i));
        }
        st.remove(beginWord);
        while(!q.isEmpty()) {
            String word = q.peek().a;
            int s = q.peek().b;
            q.remove();
            if(word.equals(endWord)) return s;

            for(int i=0; i<word.length(); i++) {
                for(char ch = 'a'; ch <= 'z'; ch++) {
                    char rep[] = word.toCharArray();
                    rep[i] = ch;
                    String rep_word = new String(rep);
                    if(st.contains(rep_word)) {
                        st.remove(rep_word);
                        q.add(new Pair(rep_word, s+1));
                    }
                }
            }
        }
        return 0;
    }
}