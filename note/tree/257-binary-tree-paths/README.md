# [Binary Tree Paths][title]

## Description

Given a binary tree, return all root-to-leaf paths.

**Note:**  A leaf is a node with no children.

**Example:**

```
Input:

   1
 /   \
2     3
 \
  5

Output: [ "1->2->5", "1->3"]

Explanation: All root-to-leaf paths are: 1- >2->5, 1->3
```

**Tags:** Tree, Depth-first Search

**Difficulty:** Easy

## 思路

题意是以字符串形式给出所有路径。用 DFS 递归，参数传入路径的字符串，而后拼接入当前节点值，到达叶节点则添加到结果数组中。

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
    List<String> list = new ArrayList<>();
    public List<String> binaryTreePaths(TreeNode root) {
        helper("", root);
        return list;
    }
    void helper(String path, TreeNode root) {
        if(root == null) {
            return;
        }
        path += root.val;
        if(root.left == null && root.right == null) {
            list.add(path);
        } else {
            path += "->";
            helper(path, root.left);
            helper(path, root.right);
        }
    }
}
```

[title]: https://leetcode.com/problems/binary-tree-paths
