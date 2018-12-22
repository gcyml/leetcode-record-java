# [Two Sum IV - Input is a BST][title]

## Description

Given a Binary Search Tree and a target number, return true if there exist two elements in the BST such that their sum is equal to the given target.

**Example 1:**  

    Input:
        5
       / \
      3   6
     / \   \
    2   4   7

    Target = 9

    Output: True

**Example 2:**  

    Input:
        5
       / \
      3   6
     / \   \
    2   4   7

    Target = 28

    Output: False

**Tags:** Tree

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
    public boolean findTarget(TreeNode root, int k) {
        // return traverseTree(root, root, k);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        TreeNode tmp;
        while(!queue.isEmpty()) {
            tmp = queue.poll();
            if(findValueBST(root, k-tmp.val, tmp)) {
                return true;
            }
            if(tmp.left != null) {
                queue.add(tmp.left);
            }
            if(tmp.right != null) {
                queue.add(tmp.right);
            }
        }
        return false;
    }
    
    // Method to find a given value using binary search
    public boolean findValueBST(TreeNode root, int val, TreeNode skipNode) {
        
        if (root == null) {
            return false;
        }
        
        if (root.val == val && root != skipNode) {
            return true;
        }
        
        if (val < root.val) {
            return findValueBST(root.left, val, skipNode);
        }
        
        return findValueBST(root.right, val, skipNode);
        
    }
}
```

[title]: https://leetcode.com/problems/two-sum-iv-input-is-a-bst
