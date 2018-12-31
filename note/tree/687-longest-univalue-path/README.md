# [Longest Univalue Path][title]

## Description

Given a binary tree, find the length of the longest path where each node in the path has the same value. This path may or may not pass through the root.

**Note:** The length of path between two nodes is represented by the number of edges between them.

**Example 1:**

Input:

```
              5
             / \
            4   5
           / \   \
          1   1   5
```

Output:

```
2
```

**Example 2:**

Input:

```
              1
             / \
            4   5
           / \   \
          4   4   5
```

Output:

```
2
```

**Note:** The given binary tree has not more than 10000 nodes. The height of the tree is not more than 1000.

**Tags:** Tree, Recursion

**Difficulty:** Easy

## 思路

题意是找出最长同值路径。
首先要找出最长同值路径，首先要找出所有节点的最长同值路径，找出其中最长的一条。
要找出一个节点的最长同值路径，需要不断向下遍历，递归返回时，若同值则路径长度不断累加，否则为 0 重新记起。
在这中间会产生一个节点其同值路径是最长的，一个节点的同值路径等于左右子树路径总和。因此，需要设置一个全局变量，不断找出最大值，递归最后得到的最大值即是二叉树的最长同值路径。

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
    int re = 0;
    public int longestUnivaluePath(TreeNode root) {
        helper(root, 0);
        return re;
    }
    public int helper(TreeNode node, int n) {
        if(node == null)
            return 0;
        int left = helper(node.left, node.val);
        int right = helper(node.right, node.val);
        re = Math.max(re, left + right);
        return node.val == n ? Math.max(left, right) + 1 : 0;

    }
}
```

[title]: https://leetcode.com/problems/longest-univalue-path
