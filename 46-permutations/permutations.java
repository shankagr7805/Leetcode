import java.util.*;

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int[] nums, List<Integer> tempList, List<List<Integer>> result) {
        if (tempList.size() == nums.length) {
            result.add(new ArrayList<>(tempList)); // Found a complete permutation
        } else {
            for (int num : nums) {
                if (tempList.contains(num)) continue; // Skip if already used
                tempList.add(num);
                backtrack(nums, tempList, result);
                tempList.remove(tempList.size() - 1); // Backtrack
            }
        }
    }
}