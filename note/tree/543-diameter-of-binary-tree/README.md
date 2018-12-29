# [Diameter of Binary Tree][title]

## Description

Given a binary tree, you need to compute the length of the diameter of the tree. The diameter of a binary tree is the length of the **longest** path between any two nodes in a tree. This path may or may not pass through the root.

**Example:**  
Given a binary tree  

```
          1
         / \
        2   3
       / \
      4   5
```

Return **3** , which is the length of the path [4,2,1,3] or [5,2,1,3].

**Note:** The length of path between two nodes is represented by the number of edges between them.

**Tags:** Tree

**Difficulty:** Easy

## 思路

题意是给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。

直径长度不等于二叉树的深度，但和深度有一定关系。

要组成直径长度，一种是经过根节点，由左右两个子树的最长路径，经过当前节点组成直径。另一种则是不经过根节点，由子树中的直径长度组成。

因此，做一个递归，做后序遍历，得到左右两个子树的最长路径，把左右两个路径相加和全局变量 `max` 比较，更新 `max`。由于 `max` 是全局变量，得到的结果即是任意两个结点路径长度中的最长值。

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
    int max = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        helper(root);
        return max;
    }
    int helper(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int left = helper(root.left);
        int right = helper(root.right);
        max = Math.max(max, left+right);
        return Math.max(left, right)+1;
    }
}
```

[title]: https://leetcode.com/problems/diameter-of-binary-tree
