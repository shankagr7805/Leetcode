class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        int i=0; int j=1;
        int cnt = 0;
        while(i<=j && j<n) {
            if(nums[i] == nums[j]) {
                j++;
            }
            else {
                i++;
                nums[i] = nums[j];
                j++;
            }
        }
        return i+1;
    }
}