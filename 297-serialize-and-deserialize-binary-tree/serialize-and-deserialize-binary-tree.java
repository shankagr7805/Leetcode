/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serial(root, sb);
        return sb.toString();
    }

    private void serial(TreeNode root, StringBuilder sb){
        if(root == null){
            sb.append("#,");
            return;
        }

        sb.append(root.val).append(',');

        serial(root.left, sb);
        serial(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<String> queue = new LinkedList<>(Arrays.asList(data.split(",")));
        return deserial(queue);
         
    }

    private TreeNode deserial(Queue<String> queue){
        if(queue.isEmpty()) return null;

        String val = queue.poll();
        if(val.equals("#")) return null;

        TreeNode root = new TreeNode(Integer.valueOf(val));
        root.left = deserial(queue);
        root.right = deserial(queue);
        return root;
    }
}