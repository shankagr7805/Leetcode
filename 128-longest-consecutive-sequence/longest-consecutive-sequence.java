class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        HashSet<Integer> s = new HashSet<>();

        if(n == 0) {
            return 0; 
        }

        for(int i=0; i<n; i++) {
            s.add(nums[i]);
        }
        int mx = 1 ;

        for(int i : s) {
            if(!s.contains(i-1)) {
                int count = 1;
                int x = i ;

                while(s.contains(x+1)) {
                    x += 1 ;
                    count += 1;
                }
                mx = Math.max(mx, count) ;
            }
        }
        return mx ;
    }
}