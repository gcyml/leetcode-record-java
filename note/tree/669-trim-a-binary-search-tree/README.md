# [Trim a Binary Search Tree][title]

## Description

Given a binary search tree and the lowest and highest boundaries as `L` and `R`, trim the tree so that all its elements lies in `[L, R]` (R >= L). You might need to change the root of the tree, so the result should return the new root of the trimmed binary search tree.

**Example 1:**  

```
Input:
    1
   / \
  0   2

  L = 1
  R = 2

Output:
    1
      \
       2
```

**Example 2:**  

```
Input:
    3
   / \
  0   4
   \
    2
   /
  1

  L = 1
  R = 3

Output:
      3
     /
   2
  /
 1
```

**Tags:** Tree

**Difficulty:** Easy

## 思路

题意是给定上界和下界，对二叉搜索树进行修剪。解法是对二叉树递归遍历，若值超过了上限，则返回修剪后的左子树；若值小于下限，则返回修剪后的右子树。

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
    public TreeNode trimBST(TreeNode root, int L, int R) {
        if(root == null) {
            return null;
        }
        if(root.val > R) {
            return trimBST(root.left, L, R);
        }
        if(root.val < L) {
            return trimBST(root.right, L, R);
        }
        root.left = trimBST(root.left, L, R);
        root.right = trimBST(root.right, L, R);
        return root;
    }
}
```

[title]: https://leetcode.com/problems/trim-a-binary-search-tree
