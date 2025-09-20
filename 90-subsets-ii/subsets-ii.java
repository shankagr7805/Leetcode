class Solution {
    private void single(int[] nums , List<List<Integer>> ans , List<Integer> s , int idx) {
        
        ans.add(new ArrayList<>(s));

        for (int i = idx; i < nums.length; i++) {
            if(i>idx && nums[i] == nums[i-1]) continue ;
            s.add(nums[i]);
            single(nums, ans, s, i + 1);
            s.remove(s.size() - 1);
        }
        return;
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        single(nums , ans , new ArrayList<>() , 0);
        return ans ;
    }
}