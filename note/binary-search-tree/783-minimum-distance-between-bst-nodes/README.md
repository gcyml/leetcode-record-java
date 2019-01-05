# [Minimum Distance Between BST Nodes][title]

## Description

Given a Binary Search Tree (BST) with the root node `root`, return the minimum difference between the values of any two different nodes in the tree.

**Example :**

```
Input: root = [4,2,6,1,3,null,null]
Output: 1
Explanation:
Note that root is a TreeNode object, not an array.

The given tree [4,2,6,1,3,null,null] is represented by the following diagram:

          4
        /   \
      2      6
     / \
    1   3  

while the minimum difference in this tree is 1, it occurs between node 1 and node 2, also between node 3 and node 2.
```

**Note:**

1. The size of the BST will be between 2 and `100`.
2. The BST is always valid, each node's value is an integer, and each node's value is different.

**Tags:** Binary Search Tree

**Difficulty:** Easy

## 思路

二叉搜索树找出最小差。由于二叉搜索树中序遍历即为正序排序，因此对二叉树做中序遍历，全局变量 prev 表示前一次遍历的值，也是当前结点排序中的前一个值，比较两个值的差，找出最小值即可。题目和 [Minimum Absolute Difference in BST][note-530] 相似。

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
    //  二叉搜索树的中序遍历即可排序
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
[note-783]: https://github.com/gcyml/leetcode-record-java/tree/master/note/binary-search-tree/530-minimum-absolute-difference-in-bst