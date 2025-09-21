class Solution {
    private void single(List<List<Integer>> ans , List<Integer> s , int k , int n , int idx) {
        if(s.size() == k && n == 0) {
            ans.add(new ArrayList<>(s));
            return;
        }
        if(n<0 || s.size() > k) return;

        for(int i=idx; i<=9; i++) {
            s.add(i);
            single(ans , s , k , n-i , i + 1);
            s.remove(s.size() - 1);
        }
    }   
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        single(ans , new ArrayList<>() , k , n , 1);
        return ans ;
    }
}