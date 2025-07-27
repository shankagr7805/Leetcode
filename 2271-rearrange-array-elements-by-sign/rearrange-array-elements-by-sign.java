class Solution {
    public int[] rearrangeArray(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];

        int pos = -2;
        int neg = -1;

        for(int i : nums) {
            if(i >= 0) {
                pos += 2;
                result[pos] = i;
            } else {
                neg += 2;
                result[neg] = i;
            }
        }

        return result ;
    }
}