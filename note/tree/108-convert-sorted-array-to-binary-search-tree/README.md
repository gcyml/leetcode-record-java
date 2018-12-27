# [Convert Sorted Array to Binary Search Tree][title]

## Description

Given an array where elements are sorted in ascending order, convert it to a height balanced BST.

For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of _every_ node never differ by more than 1.

**Example:**

```
Given the sorted array: [-10,-3,0,5,9],

One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:

      0
     / \
   -3   9
   /   /
 -10  5
```

**Tags:** Tree, Depth-first Search

**Difficulty:** Easy

## 思路

题意是将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。要使得二叉树高度差不超过 1，就要在构建二叉树时，保证左右子树的节点总数尽量相等。这里用了二分法，每次构建时把数值分成两部分构建子树。

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
   public TreeNode sortedArrayToBST(int[] nums) {
        return buildTree(nums, 0, nums.length - 1);
    }
    private TreeNode buildTree(int[] num, int start, int end) {
        if (start > end) {
            return null;
        }

        TreeNode node = new TreeNode(num[(start + end) / 2]);
        if(start == end) return node;
        node.left = buildTree(num, start, (start + end) / 2 - 1);
        node.right = buildTree(num, (start + end) / 2 + 1, end);
        return node;
    }
}
```

[title]: https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree
