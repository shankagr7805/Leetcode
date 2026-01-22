class Solution {
    public int rob_adj(int[] arr) {
        int n = arr.length;
        int prev = arr[0];
        int prev2 = 0;

        for(int i=1; i<n; i++) {
            int take = arr[i];
            if(i>1) take += prev2;

            int notTake = prev;
            int curr = Math.max(take, notTake);
            prev2 = prev;
            prev = curr;
        }

        return prev;
    }
    public int rob(int[] nums) {
        int n = nums.length;
        if(n==1) return nums[0];
        int[] temp1 = new int[n-1];
        int[] temp2 = new int[n-1];
        for(int i=0; i<n-1; i++) {
            temp1[i] = nums[i];
        }
        for(int i=1; i<n; i++) {
            temp2[i-1] = nums[i];
        }

        return Math.max(rob_adj(temp1) , rob_adj(temp2));
    }
}