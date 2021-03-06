# [Lowest Common Ancestor of a Binary Search Tree][title]

## Description

Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.

According to the [definition of LCA on Wikipedia](https://en.wikipedia.org/wiki/Lowest_common_ancestor): "The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow **a node to be a descendant of itself** )."

Given binary search tree:  root = [6,2,8,0,4,7,9,null,null,3,5]

![pic](https://assets.leetcode.com/uploads/2018/12/14/binarysearchtree_improved.png)

**Example 1:**

```
Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
Output: 6
Explanation: The LCA of nodes 2 and 8 is 6.
```

**Example 2:**

```
Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
Output: 2
Explanation: The LCA of nodes 2 and 4 is 2, since a node can be a descendant of itself according to the LCA definition.
```

**Note:**

* All of the nodes' values will be unique.
* p and q are different and both values will exist in the BST.

**Tags:** Tree

**Difficulty:** Easy

## 思路

题意是给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。

由于是二叉搜索树，若节点值大于给定范围的上限，则其节点必然在最近公共祖先的右侧；若节点值小于给定范围的下限，则其节点必然在最近公共祖先的左侧。由此，可通过不断向下递归，直到节点值在两个节点的范围内，此时则为结果节点。

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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null){
            return null;
        }
        return helper(root, Math.min(p.val, q.val), Math.max(p.val, q.val));
    }
    TreeNode helper(TreeNode root, int left, int right) {
        if (root.val > right) {
            return helper(root.left, left, right);
        } else if(root.val < left) {
            return helper(root.right, left, right);
        }
        return root;
    }
}
```

[title]: https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree
