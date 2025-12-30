class Solution {
    public boolean isPerfectSquare(int num) {
        double s = Math.sqrt(num);
        double s2 = Math.floor(s);

        return s==s2 ? true : false;
    }
}