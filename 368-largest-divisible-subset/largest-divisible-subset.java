class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int[] dp = new int[n];
        int[] hash = new int[n];
        int last = 0;
        int maxi = 1;
        for(int i=0; i<n; i++) {
            dp[i] = 1;
            hash[i] = i;
            for(int prev=0; prev<i; prev++) {
                if(1 + dp[prev] > dp[i] && nums[i] % nums[prev] == 0) {
                    dp[i] = 1 + dp[prev];
                    hash[i] = prev;
                }
            }
            if(dp[i] > maxi) {
                maxi = dp[i];
                last = i;
            }
        }
        List<Integer> lis = new ArrayList<>();
        lis.add(nums[last]);
        while(hash[last] != last) {    
            last = hash[last];
            lis.add(nums[last]);
        }
        return lis;
    }
}