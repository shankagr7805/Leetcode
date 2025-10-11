class Solution {
    public int jump(int[] nums) {
        int l=0, r=0, cnt=0;

        while(r < nums.length-1) {
            int mxm = 0;
            for(int i=l; i<=r; i++) {
                mxm = Math.max(mxm , i + nums[i]);
            }
            l = r+1;
            r = mxm;
            cnt++;
        }

        return cnt;
    }
}