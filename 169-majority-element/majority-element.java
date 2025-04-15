class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int ans = 0;
        for(int i=0; i<nums.length; i++) {
           map.put(nums[i] , map.get(nums[i]) == null ? 1 : map.get(nums[i]) + 1);

           if(map.get(nums[i]) > Math.floor(nums.length/2)) {
            ans = nums[i];
           }
        }
        return ans;
    }
}