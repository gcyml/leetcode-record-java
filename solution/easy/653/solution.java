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
    public boolean findTarget(TreeNode root, int k) {
        // return traverseTree(root, root, k);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        TreeNode tmp;
        while(!queue.isEmpty()) {
            tmp = queue.poll();
            if(findValueBST(root, k-tmp.val, tmp)) {
                return true;
            }
            if(tmp.left != null) {
                queue.add(tmp.left);
            }
            if(tmp.right != null) {
                queue.add(tmp.right);
            }
        }
        return false;
    }
    
    // Method to find a given value using binary search
    public boolean findValueBST(TreeNode root, int val, TreeNode skipNode) {
        
        if (root == null) {
            return false;
        }
        
        if (root.val == val && root != skipNode) {
            return true;
        }
        
        if (val < root.val) {
            return findValueBST(root.left, val, skipNode);
        }
        
        return findValueBST(root.right, val, skipNode);
        
    }
}