# [Maximum Depth of Binary Tree][title]

## Description

Given a binary tree, find its maximum depth.

The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

**Note:**  A leaf is a node with no children.

**Example:**

Given binary tree `[3,9,20,null,null,15,7]`,

```
    3
   / \
  9  20
    /  \
   15   7
```

return its depth = 3.

**Tags:** Tree, Depth-first Search

**Difficulty:** Easy

## 思路

题意是找出二叉树的最大深度。用递归实现，递归左右子树，得到最大值，空节点深度为 0，逐层向上，最后得到的即是最大深度。

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
    public int maxDepth(TreeNode root) {
        if(root == null)
            return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
```

[title]: https://leetcode.com/problems/maximum-depth-of-binary-tree
