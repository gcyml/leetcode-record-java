# [Sum of Left Leaves][title]

## Description

Find the sum of all left leaves in a given binary tree.

**Example:**

        3
       / \
      9  20
        /  \
       15   7

    There are two left leaves in the binary tree, with values **9** and **15** respectively. Return **24**.

**Tags:** Tree

**Difficulty:** Easy

## 思路

``` java
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
    int sum = 0;
    public int sumOfLeftLeaves(TreeNode root) {
        helper(root, false);
        return sum;
    }
    void helper(TreeNode root, boolean isLeft){
        if(root == null){
            return;
        }
        if(root.left == null && root.right == null && isLeft) {
            sum += root.val;
           
        }
        helper(root.left, true);
        helper(root.right, false);
        
    }
}
```

[title]: https://leetcode.com/problems/sum-of-left-leaves
