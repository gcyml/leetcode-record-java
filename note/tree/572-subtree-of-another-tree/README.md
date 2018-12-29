# [Subtree of Another Tree][title]

## Description

Given two non-empty binary trees **s** and **t** , check whether tree **t** has exactly the same structure and node values with a subtree of **s**. A subtree of **s** is a tree consists of a node in **s** and all of this node's descendants. The tree **s** could also be considered as a subtree of itself.

**Example 1:**  
Given tree s:

```
     3
    / \
   4   5
  / \
 1   2
```

Given tree t:

```
   4
  / \
 1   2
```

Return **true** , because t has the same structure and node values with a
subtree of s.

**Example 2:**  
Given tree s:

```
     3
    / \
   4   5
  / \
 1   2
    /
   0
```

Given tree t:

```
   4
  / \
 1   2
```

Return **false**.

**Tags:** Tree

**Difficulty:** Easy

## 思路

给定两个非空二叉树 s 和 t，检验 s 中是否包含和 t 具有相同结构和节点值的子树。

题意是判断一个二叉树是否等于另一个二叉树的子树。因此需要前序遍历每一个子树，直到某个子树等于给定的二叉树 t。因此重点在于判断两棵树是否相等。

判断两棵树相等，同样用前序遍历，判断两个结点值是否相等，而后再递归比较各自的左右子树是否相等。

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
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if(s == null || t == null) return s == null && t == null;
        return isSameTree(s, t) || isSubtree(s.left, t) || isSubtree(s.right, t);
    }
    boolean isSameTree(TreeNode s, TreeNode t){
        if(s == null || t == null) return s == null && t == null;
        if(s.val == t.val) {
            return isSameTree(s.left, t.left) && isSameTree(s.right, t.right);
        }
        return false;
    }
}
```

[title]: https://leetcode.com/problems/subtree-of-another-tree
