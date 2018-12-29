# [Two Sum IV - Input is a BST][title]

## Description

Given a Binary Search Tree and a target number, return true if there exist two elements in the BST such that their sum is equal to the given target.

**Example 1:**  

```
Input:
    5
   / \
  3   6
 / \   \
2   4   7

Target = 9

Output: True
```

**Example 2:**  

```
Input:
    5
   / \
  3   6
 / \   \
2   4   7

Target = 28

Output: False
```

**Tags:** Tree

**Difficulty:** Easy

## 思路 0

题意是给定一个二叉搜索树和值  `target`，判断二叉树中是否存在两个结点和等于 `target`。

第一种解法是递归遍历用映射表来解决。

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
    List<Integer> list = new ArrayList<>();
    public boolean findTarget(TreeNode root, int k) {
         if(root == null) {
            return false;
        }
        if(list.contains(k - root.val)) {
            return true;
        } else {
            list.add(root.val);
        }
        return findTarget(root.left, k) || findTarget(root.right, k);
    }
}
```

## 思路1

另外一种思路就是同样做深度遍历，但是通过二叉搜索树的特性，来快速找到二叉树中是否存在 `target - node.val` 的值。

 下面的实现中，先 dfs 整个树，每个结点都去遍历整棵树中是否存在对于值，注意要排除同一结点。搜索值时，若值大于搜索值 `k`， 则继续搜索左子树，否则搜索右子树。

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
        return dfs(root,root,k);
    }
    
    private boolean dfs(TreeNode root,TreeNode cur,int k){
        if(cur == null) return false;
        return search(cur,root,k-cur.val) || dfs(root,cur.left,k) || dfs(root,cur.right,k);
    }
    
    private boolean search(TreeNode root, TreeNode cur, int v){
        if(cur == null) return false;
        if(cur != root && cur.val == v) return true;
        return v < cur.val ? search(root,cur.left,v) : search(root,cur.right,v);
    }
}

```

[title]: https://leetcode.com/problems/two-sum-iv-input-is-a-bst
