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
class Tuple {
    TreeNode node;
    int row;
    int col;
    public Tuple(TreeNode _node, int _row, int _col) {
        node = _node;
        row = _row;
        col = _col;
    }
}
class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> mp = new TreeMap<>();
        Queue<Tuple> q = new LinkedList<Tuple>();
        q.offer(new Tuple(root, 0, 0));
        while(!q.isEmpty()) {
            Tuple t = q.poll();
            TreeNode node = t.node;
            int x = t.row;
            int y = t.col;
            mp.putIfAbsent(y, new TreeMap<>());
            mp.get(y).putIfAbsent(x, new PriorityQueue<>());
            mp.get(y).get(x).offer(node.val);

            if(node.left != null) q.offer(new Tuple(node.left, x+1, y-1));
            if(node.right != null) q.offer(new Tuple(node.right, x+1, y+1));
        }
        List<List<Integer>> ans = new ArrayList<>();
        for(TreeMap<Integer, PriorityQueue<Integer>> ys : mp.values()) {
            ans.add(new ArrayList<>());
            for(PriorityQueue<Integer> nodes : ys.values()) {
                while(!nodes.isEmpty()) {
                    ans.get(ans.size()-1).add(nodes.poll());
                }
            }
        }
        return ans;
    }
}