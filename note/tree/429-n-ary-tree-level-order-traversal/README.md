# [N-ary Tree Level Order Traversal][title]

## Description

Given an n-ary tree, return the level order traversal of its nodes' values.(ie, from left to right, level by level).

For example, given a `3-ary` tree:

![pic](https://assets.leetcode.com/uploads/2018/10/12/narytreeexample.png)

We should return its level order traversal:

```
[
     [1],
     [3,2,4],
     [5,6]
]
```

**Note:**

  1. The depth of the tree is at most `1000`.
  2. The total number of nodes is at most `5000`.

**Tags:** Tree, Breadth-first Search

**Difficulty:** Easy

## 思路

要把同一层的节点全部记录在一起，用的是深度优先的方法。逐层递归，每向下一层，则添加一个 list，由于带上了当前深度的参数，因此可以把节点值添加到对应层的 list 中。

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
            helper(0, root);
        }
        return res;
    }
    public void helper(int depth, Node root) {
        if(res.size() <= depth){
            res.add(new ArrayList<Integer>());
        }
        res.get(depth).add(root.val);
        for(Node node : root.children) {
            helper(depth+1, node);
        }
    }
}
```

[title]: https://leetcode.com/problems/n-ary-tree-level-order-traversal
