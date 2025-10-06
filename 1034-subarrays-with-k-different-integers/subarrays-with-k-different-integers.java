class Solution {
    private int lessThanK(int[] nums , int k) {
        int l = 0, r = 0, cnt = 0;
        HashMap<Integer, Integer> mp = new HashMap<>();
        while (r < nums.length) {
            mp.put(nums[r], mp.getOrDefault(nums[r], 0) + 1);
            while (mp.size() > k) {
                mp.put(nums[l], mp.get(nums[l]) - 1);
                if (mp.get(nums[l]) == 0) {
                    mp.remove(nums[l]);
                }
                l++;
            }
            cnt = cnt + (r-l+1);
            r++;
        }
        return cnt;
    } 
    public int subarraysWithKDistinct(int[] nums, int k) {
        return lessThanK(nums, k) - lessThanK(nums, k-1);
    }
}