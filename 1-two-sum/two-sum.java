class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] indices = new int[2];
       HashMap<Integer,Integer> mp = new HashMap<>();
        for(int i=0; i<nums.length; i++) {
            int rem = target - nums[i];
            if(mp.containsKey(rem)) {
                indices[0] = mp.get(rem);
                indices[1] = i;
                return indices;
            } else {
                mp.put(nums[i] , i);
            }
        }
        return indices;  
    }
}