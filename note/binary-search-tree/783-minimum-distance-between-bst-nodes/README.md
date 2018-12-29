# [Minimum Distance Between BST Nodes][title]

## Description

Given a Binary Search Tree (BST) with the root node `root`, return the minimum
difference between the values of any two different nodes in the tree.

**Example :**
        

**Note:**

  1. The size of the BST will be between 2 and `100`.
  2. The BST is always valid, each node's value is an integer, and each node's value is different.


**Tags:** Binary Search Tree

**Difficulty:** Easy

## 思路

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
    ArrayList<Integer> set = new ArrayList<>();
    public int minDiffInBST(TreeNode root) {
        ans = Integer.MAX_VALUE;
        helper(root);
        return ans;
        
    }
    //  äºåæç´¢æ çä¸­åºéåå³å¯æåº
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

[title]: https://leetcode.com/problems/minimum-distance-between-bst-nodes