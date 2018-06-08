/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    int h = 0;
    List<Integer> res = new ArrayList<>();
    public List<Integer> largestValues(TreeNode root) {
        if(root != null) {
            largestValuesHelper(root, 1);

        }
        
        return res;
    }
    public void largestValuesHelper(TreeNode root, int depth) {
        if(h < depth) {
            h = depth;
            res.add(root.val);
        } else if(res.get(depth-1) < root.val) {
           res.set(depth-1, root.val);         
        }
        if(root.left != null) {
            largestValuesHelper(root.left, depth+1);
        }
        if(root.right != null) {
            largestValuesHelper(root.right, depth+1);
        }
        
    }
}