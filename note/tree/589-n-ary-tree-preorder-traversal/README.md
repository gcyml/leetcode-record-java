# [N-ary Tree Preorder Traversal][title]

## Description

Given an n-ary tree, return the _preorder_ traversal of its nodes ' values.

For example, given a `3-ary` tree:

![pic](https://assets.leetcode.com/uploads/2018/10/12/narytreeexample.png)

Return its preorder traversal as: `[1,3,5,6,2,4]`.

**Note:**

Recursive solution is trivial, could you do it iteratively?

**Tags:** Tree

**Difficulty:** Easy

## 思路

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
    public List<Integer> preorder(Node root) {
        helper(root);
        return res;
    }
    void helper(Node root) {
        if(root == null) return;
        res.add(root.val);
        for(Node child : root.children) {
            helper(child);
        }
        
    }
    
}
```

[title]: https://leetcode.com/problems/n-ary-tree-preorder-traversal
