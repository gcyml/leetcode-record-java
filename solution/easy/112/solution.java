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
    int sum;
    boolean hasPathSum =false;
    public boolean hasPathSum(TreeNode root, int sum) {
        this.sum = sum;
        helper(0, root);
        return hasPathSum;
    }
    public void helper(int curSum, TreeNode root){
        if(root != null && !hasPathSum) {
            curSum += root.val;
            if(root.left == null && root.right == null) {
                if(curSum == sum) {
                    hasPathSum = true;                    
                }
            } else {
                helper(curSum, root.left);
                helper(curSum, root.right);
            }
        }
    }
}