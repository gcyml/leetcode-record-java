# [Maximum Depth of N-ary Tree][title]

## Description

Given a n-ary tree, find its maximum depth.

The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

For example, given a `3-ary` tree:

![pic](https://assets.leetcode.com/uploads/2018/10/12/narytreeexample.png)

We should return its max depth, which is 3.

**Note:**

1. The depth of the tree is at most `1000`.
2. The total number of nodes is at most `5000`.


**Tags:** Tree, Depth-first Search, Breadth-first Search

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
    public int maxDepth(Node root) {
        if(root == null) {
            return 0;
        }
        return helper(0, root);
    }
    public int helper(int depth, Node root) {
        depth += 1;
        // System.out.println(root.val + "," + depth);
        int max = depth;
        for(Node node : root.children) {
            max = Math.max(helper(depth, node), max);
        }
        return max;
    }
}
```

[title]: https://leetcode.com/problems/maximum-depth-of-n-ary-tree
