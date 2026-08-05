class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int[] dp = new int[n];
        int[] hash = new int[n];

        int maxi = 1; int li = 0;
        for(int i=0; i<n; i++) {
            dp[i] = 1;
            hash[i] = i;
            for(int j=0; j<i; j++) {
                if(nums[i] % nums[j] == 0 && 1 + dp[j] > dp[i]) {
                    dp[i] = 1 + dp[j];
                    hash[i] = j;
                }
            }
            if(dp[i] > maxi) {
                maxi = dp[i];
                li = i;
            }
        }

        List<Integer> list = new ArrayList<>();
        list.add(nums[li]);

        while(hash[li] != li) {
            li = hash[li];
            list.add(nums[li]);
        }
        Collections.reverse(list);

        return list;
    }
}