# [N-ary Tree Level Order Traversal][title]

## Description

Given an n-ary tree, return the level order traversal of its nodes' values.(ie, from left to right, level by level).

For example, given a `3-ary` tree:


![pic](https://assets.leetcode.com/uploads/2018/10/12/narytreeexample.png)

We should return its level order traversal:

    [
         [1],
         [3,2,4],
         [5,6]
    ]

**Note:**

  1. The depth of the tree is at most `1000`.
  2. The total number of nodes is at most `5000`.


**Tags:** Tree, Breadth-first Search

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
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> levelOrder(Node root) {
        if(root != null) {
            helper(1, root);
        }
        return res;
    }
    public void helper(int depth, Node root) {
        if(res.size() < depth){
            res.add(new ArrayList<Integer>());
        }
        res.get(depth-1).add(root.val);
        for(Node node : root.children) {
            helper(depth+1, node);
        }
    }
}
```

[title]: https://leetcode.com/problems/n-ary-tree-level-order-traversal
