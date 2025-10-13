class Solution {
    public int lengthOfLastWord(String s) {
        int n = s.length();
        int i = n - 1;

        while (i >= 0) {
            if (s.charAt(i) == ' ')
                i--;
            else
                break;
        }
        int ans = 0;
        while (i >= 0 && s.charAt(i) != ' ') {
            ans++;
            i--;
        }
        return ans;
    }
}