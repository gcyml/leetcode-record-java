# [Balanced Binary Tree][title]

## Description

Given a binary tree, determine if it is height-balanced.

For this problem, a height-balanced binary tree is defined as:

> a binary tree in which the depth of the two subtrees of _every_ node never differ by more than 1.

**Example 1:**

Given the following tree `[3,9,20,null,null,15,7]`:

```
    3
   / \
  9  20
    /  \
   15   7
```

Return true.  
  
**Example 2:**

Given the following tree `[1,2,2,3,3,null,null,4,4]`:

```
       1
      / \
     2   2
    / \
   3   3
  / \
 4   4
```

Return false.

**Tags:** Tree, Depth-first Search

**Difficulty:** Easy

## 思路

题意是判断二叉树是否为高度平衡二叉树。此题同样用到了递归，每次判断节点的两个子树高度差是否小于等于 1，若符合则，再往下递归。寻找高度差的方法 `findDeep` 同样用的是递归的方法，从 0 开始逐层向下递归，找出树的高度。

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
```

[title]: https://leetcode.com/problems/balanced-binary-tree
