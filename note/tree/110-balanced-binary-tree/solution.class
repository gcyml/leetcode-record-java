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
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        if(Math.abs(findDeep(root.left)-findDeep(root.right)) <= 1) {
            return isBalanced(root.left) && isBalanced(root.right);
        }
        return false;
    }
    public int findDeep(TreeNode root)  
    {  
        int deep = 0;  
        if(root != null)  
        {  
            int lchilddeep = findDeep(root.left);  
            int rchilddeep = findDeep(root.right);  
            deep = lchilddeep > rchilddeep ? lchilddeep + 1 : rchilddeep + 1;  
        }  
        return deep;  
    }
}