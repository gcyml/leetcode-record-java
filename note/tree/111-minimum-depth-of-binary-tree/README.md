# [Minimum Depth of Binary Tree][title]

## Description

Given a binary tree, find its minimum depth.

The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.

**Note:**  A leaf is a node with no children.

**Example:**

Given binary tree `[3,9,20,null,null,15,7]`,

        3
       / \
      9  20
        /  \
       15   7

return its minimum depth = 2.


**Tags:** Tree, Depth-first Search, Breadth-first Search

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
```

[title]: https://leetcode.com/problems/minimum-depth-of-binary-tree
