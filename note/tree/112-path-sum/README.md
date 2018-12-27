# [Path Sum][title]

## Description

Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.

**Note:**  A leaf is a node with no children.

**Example:**

Given the below binary tree and `sum = 22`,

```
              5
             / \
            4   8
           /   / \
          11  13  4
         /  \      \
        7    2      1
```

return true, as there exist a root-to-leaf path `5->4->11->2` which sum is 22.

**Tags:** Tree, Depth-first Search

**Difficulty:** Easy

## 思路

题意是给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。

解法是用 DFS 对二叉树进行递归，传入一个参数，记录当前路径的节点值总和。若到叶子节点时，该值等于给定的 sum，则说明符合条件。

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
    int sum;
    boolean hasPathSum =false;
    public boolean hasPathSum(TreeNode root, int sum) {
        this.sum = sum;
        helper(0, root);
        return hasPathSum;
    }
    public void helper(int curSum, TreeNode root){
        if(root != null && !hasPathSum) {
            curSum += root.val;
            if(root.left == null && root.right == null) {
                if(curSum == sum) {
                    hasPathSum = true;
                }
            } else {
                helper(curSum, root.left);
                helper(curSum, root.right);
            }
        }
    }
}
```

[title]: https://leetcode.com/problems/path-sum
