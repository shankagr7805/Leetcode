class Solution {
    private void single(List<List<Integer>> ans , int[] nums , List<Integer> s , int temp) {
        if(temp == nums.length) {
            ans.add(new ArrayList<>(s)) ;
            return ;
        }
        single(ans , nums , s , temp + 1);

        s.add(nums[temp]);
        single(ans , nums , s , temp + 1);
        s.remove(s.size() - 1);     // Backtracking
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();

        single(ans , nums , new ArrayList<>() , 0);

        return ans ;
    }
}