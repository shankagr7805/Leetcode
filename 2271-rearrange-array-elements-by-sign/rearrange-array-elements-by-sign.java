class Solution {
    public int[] rearrangeArray(int[] nums) {
        int n = nums.length;
        ArrayList<Integer> pos = new ArrayList<>();
        ArrayList<Integer> neg = new ArrayList<>();

        for(int i=0; i<n; i++) {
            if(nums[i] >= 0) {
                pos.add(nums[i]);
            } else {
                neg.add(nums[i]);
            }
        }
        int[] rearr = new int[n];
        for(int i=0; i <= n-1; i+=2) {
            rearr[i] = pos.get(i/2);
            if(i<n-1) {
                rearr[i+1] = neg.get(i/2);
            }   
        }

        return rearr ;
    }
}