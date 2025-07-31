class Solution {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        HashMap<Integer, Integer> mp = new HashMap<>();
        int sum = 0;
        int count = 0;

        mp.put(0,1) ;

        for (int i = 0; i < n; i++) {
            sum += nums[i];
            int rem = sum - k;
            count += mp.getOrDefault(rem,0);
            mp.put(sum, mp.getOrDefault(sum,0)+1);
        }

        return count;
    }
}