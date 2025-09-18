class Solution {
    private void newStr( List<String> res , String s , int open , int close , int n) {
        if(s.length() == 2*n) {
            res.add(s);
            return;
        }
        if(open < n) {
            newStr(res , s + "(" , open + 1 , close , n) ;
        }
        if(close < open) {
            newStr(res , s + ")" , open , close + 1 , n) ;
        } 
    }
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();

        newStr(res , "" , 0 , 0 , n);

        return res;
    }
}