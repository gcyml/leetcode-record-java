# [Find Mode in Binary Search Tree][title]

## Description

Given a binary search tree (BST) with duplicates, find all the [mode(s)](https://en.wikipedia.org/wiki/Mode_\(statistics\)) (the most frequently occurred element) in the given BST.

Assume a BST is defined as follows:

* The left subtree of a node contains only nodes with keys **less than or equal to** the node 's key.
* The right subtree of a node contains only nodes with keys **greater than or equal to** the node 's key.
* Both the left and right subtrees must also be binary search trees.

For example:  
Given BST `[1,null,2,2]`,

```
   1
    \
     2
    /
   2
```

return `[2]`.

**Note:** If a tree has more than one mode, you can return them in any order.

**Follow up:** Could you do that without using any extra space? (Assume that
the implicit stack space incurred due to recursion does not count).

**Tags:** Tree

**Difficulty:** Easy

## 思路

题意是找出二叉搜索树中的众数。二叉搜索树有个特性就是，中序遍历即为排序输出。所以题目就变成了从已排序的序列中找出众数。
对二叉树做中序遍历，若前一个值和当前值相等，则频数 `cnt` 加 1，否则重置频数为 1。若频数超过了最大值，则清空众数列表，写入。若等于最大值，则说明有多个众数，在列表后添加即可。

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
    int cnt = 0, max = Integer.MIN_VALUE, pre;
    List<Integer> list = new ArrayList<>();
    public int[] findMode(TreeNode root) {
        helper(root);
        int[] res = new int[list.size()];
        for(int i=0;i<list.size();i++){
            res[i] = list.get(i);
        }
        return res;
    }
    void helper(TreeNode root) {
        if(root == null) {
            return;
        }
        helper(root.left);
        if(pre == root.val) {
            cnt++;
        } else {
            cnt = 1;
        }
        if(cnt > max) {
            list.clear();
            list.add(root.val);
            max = cnt;
        } else if (cnt == max) {
            list.add(root.val);
        }
        pre = root.val;
        helper(root.right);
    }
}
```

[title]: https://leetcode.com/problems/find-mode-in-binary-search-tree
