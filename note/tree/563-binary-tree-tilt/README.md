# [Binary Tree Tilt][title]

## Description

Given a binary tree, return the tilt of the **whole tree**.

The tilt of a **tree node** is defined as the **absolute difference** between the sum of all left subtree node values and the sum of all right subtree node values. Null node has tilt 0.

The tilt of the **whole tree** is defined as the sum of all nodes' tilt.

**Example:**  

```
Input:
         1
       /   \
      2     3
Output: 1
Explanation:
Tilt of node 2 : 0
Tilt of node 3 : 0
Tilt of node 1 : |2-3| = 1
Tilt of binary tree : 0 + 0 + 1 = 1
```

**Note:**

1. The sum of node values in any subtree won't exceed the range of 32-bit integer.
2. All the tilt values won't exceed the range of 32-bit integer.

**Tags:** Tree

**Difficulty:** Easy

## 思路

给定一个二叉树，计算整个树的坡度。

一个树的节点的坡度定义即为，该节点左子树的结点之和和右子树结点之和的差的绝对值。空结点的的坡度是0。

求二叉树的结点和，用后序遍历即可。由于题目是求整棵树的坡度，因此需要一个全局变量 `sum`，累加上每一个结点的左右子树结点之和的差的绝对值。

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
    int sum = 0;
    public int findTilt(TreeNode root) {
        helper(root);
        return sum;
    }
    int helper(TreeNode root){
        if(root == null) return 0;
        int leftSum = helper(root.left);
        int rightSum = helper(root.right);
        sum += Math.abs(leftSum - rightSum);
        return leftSum + rightSum + root.val;
    }
}
```

[title]: https://leetcode.com/problems/binary-tree-tilt
