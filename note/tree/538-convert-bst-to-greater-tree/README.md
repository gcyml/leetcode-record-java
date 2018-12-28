# [Convert BST to Greater Tree][title]

## Description

Given a Binary Search Tree (BST), convert it to a Greater Tree such that every key of the original BST is changed to the original key plus sum of all keys greater than the original key in BST.

**Example:**

```
Input: The root of a Binary Search Tree like this:
              5
            /   \
           2     13

Output: The root of a Greater Tree like this:
             18
            /   \
          20     13
```

**Tags:** Tree

**Difficulty:** Easy

## 思路

题意是把搜索二叉树的每一个节点都加上比他大的值，返回得到的二叉树。一般指明了给出的是搜索二叉树，即要用到搜索二叉树的特点，中序遍历等于正序排序。在二叉树中，中序遍历首先遍历左子树，然后访问根结点，最后遍历右子树。
但是在这里中，我们并不需要正序排序，我们需要从大到小，依次得到值，把前面的总和加到当前值。因此，我们用的是 `右中左`，这样即可得到倒序排序。

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
    int sum =0;
    public TreeNode convertBST(TreeNode root) {
        helper(root);
        return root;
    }
    void helper(TreeNode root) {
        if(root == null) {
            return;
        }
        helper(root.right);
        sum += root.val;
        root.val = sum;
        helper(root.left);
    }
}
```

[title]: https://leetcode.com/problems/convert-bst-to-greater-tree
