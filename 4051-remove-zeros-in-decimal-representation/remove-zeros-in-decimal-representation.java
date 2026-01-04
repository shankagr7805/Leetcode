class Solution {
    public long removeZeros(long n) {
        StringBuilder sb = new StringBuilder();
        while(n>0) {
            if(n%10 != 0) {
                sb.append(n%10);
            }
            n /= 10;
        }

        return Long.parseLong(sb.reverse().toString());
    }
}