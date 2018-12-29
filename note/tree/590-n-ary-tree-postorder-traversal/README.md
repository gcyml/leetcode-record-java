# [N-ary Tree Postorder Traversal][title]

## Description

Given an n-ary tree, return the _postorder_ traversal of its nodes ' values.

For example, given a `3-ary` tree:

![pic](https://assets.leetcode.com/uploads/2018/10/12/narytreeexample.png)

Return its postorder traversal as: `[5,6,3,2,4,1]`.

**Note:**

Recursive solution is trivial, could you do it iteratively?

**Tags:** Tree

**Difficulty:** Easy

## 思路

n 叉树的后序遍历实现。用递归，先遍历子树，而后添加结点值。

``` java
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/
class Solution {
    List<Integer> res = new ArrayList<>();
    public List<Integer> postorder(Node root) {
        helper(root);
        return res;
    }
    void helper(Node root) {
        if(root == null) return;
        for(Node child : root.children) {
            helper(child);
        }
        res.add(root.val);
    }
}
```

[title]: https://leetcode.com/problems/n-ary-tree-postorder-traversal
