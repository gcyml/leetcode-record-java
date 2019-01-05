# [Minimum Absolute Difference in BST][title]

## Description

Given a binary search tree with non-negative values, find the minimum [absolute difference](https://en.wikipedia.org/wiki/Absolute_difference) between values of any two nodes.

**Example:**

```
Input:

   1
    \
     3
    /
   2

Output:
1

Explanation:
The minimum absolute difference is 1, which is the difference between 2 and 1 (or between 2 and 3).
```

**Note:** There are at least two nodes in this BST.

**Tags:** Binary Search Tree

**Difficulty:** Easy

## 思路

二叉搜索树找出最小绝对值差。由于二叉搜索树中序遍历即为正序排序，因此对二叉树做中序遍历，全局变量 prev 表示前一次遍历的值，也是当前结点排序中的前一个值，比较两个值的差，找出最小绝对值即可。

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
    Integer prev, ans;
    public int getMinimumDifference(TreeNode root) {
        ans = Integer.MAX_VALUE;
        helper(root);
        return ans;
    }
    public void helper(TreeNode node) {
        if(node == null) {
            return;
        }
        helper(node.left);
        if(prev != null) {
             ans = Math.min(node.val-prev, ans);
        }
        prev = node.val;
        helper(node.right);
    }
}
```

[title]: https://leetcode.com/problems/minimum-absolute-difference-in-bst
