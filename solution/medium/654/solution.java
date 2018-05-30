/* -----------------------------------
 *  WARNING:
 * -----------------------------------
 *  Your code may fail to compile
 *  because it contains public class
 *  declarations.
 *  To fix this, please remove the
 *  "public" keyword from your class
 *  declarations.
 */

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
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if(nums.length == 0) return null;
        return buildTree(nums, 0, nums.length-1);
    }
    public TreeNode buildTree(int[] nums, int start, int end) {
        if(start > end) return null;
        int max = java.lang.Integer.MIN_VALUE;
        // 找出最大值
        int index = start;
        for(int i=start+1;i<end+1;i++) {
            if(nums[i] > max) {
                index = i;
                max = nums[i];
            }
        }
    
        TreeNode root = new TreeNode(nums[index]);
        root.left = buildTree(nums, start, index-1);
        root.right = buildTree(nums, index+1, end);
        return root;
    }
}