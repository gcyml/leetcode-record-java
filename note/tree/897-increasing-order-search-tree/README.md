# [Increasing Order Search Tree][title]

## Description

Given a tree, rearrange the tree in **in-order** so that the leftmost node in the tree is now the root of the tree, and every node has no left child and only 1 right child.

**Example 1:**

    Input: [5,3,6,2,4,null,8,1,null,null,null,7,9]

           5
          / \
        3    6
       / \    \
      2   4    8
      /        / \
    1        7   9

    Output: [1,null,2,null,3,null,4,null,5,null,6,null,7,null,8,null,9]

     1
       \
       2
        \
         3
          \
           4
            \
             5
              \
               6
                \
                 7
                  \
                   8
                    \
                     9  

**Note:**

1. The number of nodes in the given tree will be between 1 and 100.
2. Each node will have a unique integer value from 0 to 1000.

**Tags:** Tree, Depth-first Search

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
    ArrayList<Integer> list = new ArrayList<>();
    public TreeNode increasingBST(TreeNode root) {
        iteratorTree(root);
        // Collections.sort(list);
        root = new TreeNode(list.get(0));
        TreeNode res = root;
        for(int i = 1;i<list.size();i++) {
            root.right = new TreeNode(list.get(i));
            root = root.right;
        }
        return res;
    }
    public void iteratorTree(TreeNode root) {
        if(root == null) {
            return;
        }
        iteratorTree(root.left);
        list.add(root.val);
        iteratorTree(root.right);
    }
}
```

[title]: https://leetcode.com/problems/increasing-order-search-tree
