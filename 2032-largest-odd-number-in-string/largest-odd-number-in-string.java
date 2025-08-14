class Solution {
    public String largestOddNumber(String num) {
        int max = -1;
        for(int i=num.length()-1 ; i>=0; i--) {
            if((num.charAt(i) - '0')%2 != 0) {
                max = i;
                break;
            }
        }
        if(max == -1) {
            return "";
        } else {
            return num.substring(0, max+1);
        }
    }
}