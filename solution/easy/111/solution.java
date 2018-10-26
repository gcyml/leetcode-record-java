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
    public int minDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }
        return helper(1, root);
    }
    public int helper(int depth, TreeNode root) {        
        if(root.left == null && root.right == null) {
            return depth;
        }
        int left = Integer.MAX_VALUE, right = Integer.MAX_VALUE;
        if(root.left != null) {
            left = helper(depth+1, root.left);
        }
        if(root.right != null) {
            right = helper(depth+1, root.right);
        }
        return Math.min(left, right);
    }
}