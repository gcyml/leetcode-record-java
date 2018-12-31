# [Leaf-Similar Trees][title]

## Description

Consider all the leaves of a binary tree.  From left to right order, the values of those leaves form a _leaf value sequence._

![pic](https://s3-lc-upload.s3.amazonaws.com/uploads/2018/07/16/tree.png)

For example, in the given tree above, the leaf value sequence is `(6, 7, 4, 9, 8)`.

Two binary trees are considered _leaf-similar_  if their leaf value sequence is the same.

Return `true` if and only if the two given trees with head nodes `root1` and `root2` are leaf-similar.

**Note:**

* Both of the given trees will have between `1` and `100` nodes.

**Tags:** Tree, Depth-first Search

**Difficulty:** Easy

## 思路

两棵树做 DFS，记录叶子到列表中，若两个列表大小相同，且值均对应相等，则为真。

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
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = new ArrayList<>(), list2 = new ArrayList<>();
        helper(list1, root1);
        helper(list2, root2);
        if(list1.size() != list2.size()) {
            return false;
        }
        for(int i=0;i<list1.size();i++){
            if(list1.get(i) != list2.get(i)) {
                return false;
            }
        }
        return true;
    }
    public void helper(List<Integer> list, TreeNode root) {
        if(root != null) {
            if(root.left == null && root.right == null) {
                list.add(root.val);
            } else {
                helper(list, root.left);
                helper(list, root.right);
            }
        }
    }
}
```

[title]: https://leetcode.com/problems/leaf-similar-trees
