# [Binary Tree Level Order Traversal II][title]

## Description

Given a binary tree, return the _bottom-up level order_ traversal of its
nodes' values. (ie, from left to right, level by level from leaf to root).

For example:  
Given binary tree `[3,9,20,null,null,15,7]`,  

```
    3
   / \
  9  20
    /  \
   15   7
```

return its bottom-up level order traversal as:  

```
[
  [15,7],
  [9,20],
  [3]
]
```

**Tags:** Tree, Breadth-first Search

**Difficulty:** Easy

## 思路

题意是给定一个二叉树，返回其节点值自底向上的层次遍历。首先要遍历得到每一层的节点值，而后还需要自下而上进行添加到列表中。遍历每一层的值的方法，这里用的是队列的方法，用 `nextIndex` 表示下一层的节点数，用 `curIndex` 表示队列中剩余的该层节点数。由于队列先进先出的特性，先把当前层压入队列，而后逐个弹出，并计算出下一层的节点数。队列中当前层节点清空后，由 `nextIndex` 传给 `curIndex`， `nextIndex` 置 0，重新计算层节点数，同时把当前层的所有值添加到数组中。
需要注意的是，由于此处遍历是自上而下，需要把数组反转后，才是自下而上的遍历结果。

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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(root == null)
            return result;
        List<List<Integer>> levelListRes = new ArrayList<List<Integer>>();
        ArrayList<Integer> levelres = new ArrayList<Integer>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int curIndex = 1;
        int nextIndex = 0;
        while(!q.isEmpty())
        {
            curIndex--;
            TreeNode top = q.poll();
            levelres.add(top.val);
            if(top.left != null) {
                nextIndex++;
                q.add(top.left);
            }
            if(top.right != null) {
                q.add(top.right);
                nextIndex++;
            }
            if(curIndex == 0) {
                curIndex = nextIndex;
                nextIndex = 0;
                levelListRes.add(levelres);
                levelres = new ArrayList<Integer>();
            }
        }
        for(int i = levelListRes.size()-1;i>=0;i--) {
            result.add(levelListRes.get(i));
        }
        return result;
    }
}
```

[title]: https://leetcode.com/problems/binary-tree-level-order-traversal-ii
