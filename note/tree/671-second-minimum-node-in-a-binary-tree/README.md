# [Second Minimum Node In a Binary Tree][title]

## Description

Given a non-empty special binary tree consisting of nodes with the non-negative value, where each node in this tree has exactly `two` or `zero` sub-node. If the node has two sub-nodes, then this node's value is the smaller value among its two sub-nodes.

Given such a binary tree, you need to output the **second minimum** value in the set made of all the nodes' value in the whole tree.

If no such second minimum value exists, output -1 instead.

**Example 1:**  

```
Input:
    2
   / \
  2   5
     / \
    5   7

Output: 5
Explanation: The smallest value is 2, the second smallest value is 5.
```

**Example 2:**  

```
Input:
    2
   / \
  2   2

Output: -1
Explanation: The smallest value is 2, but there isn't any second smallest value.
```

**Tags:** Tree

**Difficulty:** Easy

## 思路

根据题意，节点值不大于子节点的值。因此根节点必然是最小值。知道了最小值，递归遍历找出第二小的值即可。

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
    int second = Integer.MAX_VALUE;
    public int findSecondMinimumValue(TreeNode root) {
        helper(root, root.val);
        return second == Integer.MAX_VALUE?-1:second;
    }
    void helper(TreeNode root, int val) {
        if(root == null) {
            return;
        }
        if(root.val > val && second > root.val) {
            second = root.val;
        }
        helper(root.left, val);
        helper(root.right, val);
    }
}
```

[title]: https://leetcode.com/problems/second-minimum-node-in-a-binary-tree
