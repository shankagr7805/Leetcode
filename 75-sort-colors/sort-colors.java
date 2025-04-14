class Solution {
    public void sortColors(int[] nums) {
        int count_0 = 0;int count_1 = 0; int count_2 = 0;
        for(int i=0; i<nums.length; i++) {
            if(nums[i] == 0) {
                count_0 ++;
            } else if(nums[i] == 1) {
                count_1 ++;
            } else {
                count_2 ++;
            }
        }
        Arrays.fill(nums , 0 , count_0 , 0);
        Arrays.fill(nums , count_0 , count_0 + count_1 , 1);
        Arrays.fill(nums , count_0 + count_1 , nums.length , 2);
    
        return ;
    }
}