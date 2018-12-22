# [Binary Tree Level Order Traversal II][title]

## Description

Given a binary tree, return the _bottom-up level order_ traversal of its
nodes' values. (ie, from left to right, level by level from leaf to root).

For example:  
Given binary tree `[3,9,20,null,null,15,7]`,  

        3
       / \
      9  20
        /  \
       15   7

return its bottom-up level order traversal as:  

    [
      [15,7],
      [9,20],
      [3]
    ]

**Tags:** Tree, Breadth-first Search

**Difficulty:** Easy

## 思路

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
        q.add(root);//å°sä½ä¸ºèµ·å§é¡¶ç¹å å¥éå
        int curIndex = 1;
        int nextIndex = 0;
        while(!q.isEmpty())
        {
            curIndex--;
            TreeNode top = q.poll(); //ååºéé¦åç´ 
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
