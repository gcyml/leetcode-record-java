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
    int res = 0;
    int h = 0;
    public int findBottomLeftValue(TreeNode root) {            
        findBottomLeftValueHelper(root, 1);
        return res;
            
    }
    public void findBottomLeftValueHelper(TreeNode root, int depth) {
        if(h < depth) {
            res = root.val;
            h = depth;
        }
        // 优先找左边，因此递归进来的第一个值是左节点值
        if(root.left != null) {
            findBottomLeftValueHelper(root.left, depth+1);
        }
        if(root.right != null) {
            findBottomLeftValueHelper(root.right, depth+1);
        }
    }
}