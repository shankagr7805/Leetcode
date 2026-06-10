/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private List<Integer> ans = new ArrayList<>();

    private List<Integer> in(TreeNode root) {
        if(root == null) return ans;
        in(root.left);
        ans.add(root.val);
        in(root.right);

        return ans;
    }

    private boolean bs(TreeNode root, int k, int i) {
        int low = 0; int high = ans.size()-1;
        while(low <= high) {
            int mid = low + (high - low) / 2;
            System.out.println(low + " " + mid + " " + high);
            if(k == ans.get(mid) && mid != i) return true;
            else if(k > ans.get(mid)) low = mid + 1;
            else high = mid - 1;
        }
        return false;
    }
    public boolean findTarget(TreeNode root, int k) {
        ans = in(root);
        for(int i=0; i<ans.size(); i++) {
            if(bs(root, k-ans.get(i), i)) return true;
        }
        return false;
    }
}