class Solution {
    private static final String[] KEYPAD = {
        "",    "",    "abc", "def",
        "ghi", "jkl", "mno", "pqrs",
        "tuv", "wxyz"
    };
    
    private void back(String digits , List<String> ans , StringBuilder sb , int idx) {
        if(idx == digits.length()) {
            ans.add(sb.toString());
            return;
        }
        String letters = KEYPAD[digits.charAt(idx) - '0'];

        for(char c : letters.toCharArray()) {
            sb.append(c);
            back(digits , ans , sb , idx + 1);
            sb.deleteCharAt(sb.length() - 1) ;
        }
    }
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        if(digits == null || digits.length() == 0) return ans;
        back(digits , ans , new StringBuilder() , 0);

        return ans ;
    }
}