# [Average of Levels in Binary Tree][title]

## Description

Given a non-empty binary tree, return the average value of the nodes on each level in the form of an array.

**Example 1:**  

```
Input:
    3
   / \
  9  20
    /  \
   15   7
Output: [3, 14.5, 11]
Explanation:
The average value of nodes on level 0 is 3,  on level 1 is 14.5, and on level 2 is 11. Hence return [3, 14.5, 11].
```

**Note:**  

1. The range of node's value is in the range of 32-bit signed integer.

**Tags:** Tree

**Difficulty:** Easy

## 思路

题意是返回二叉树中每一层的平均值。既然是求每一层，自然是用 BFS。这里用了队列来实现广度优先搜索。计算每层总和，每层遍历结束时，计算平均值。

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
    public List<Double> averageOfLevels(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<Double> result = new ArrayList<Double>();
        int curIndex = 1;
        int nextIndex = 0;
        double nodeSum = 1;
        double sum = 0;
        queue.offer(root);
        while(!queue.isEmpty()) {
            root = queue.poll();
            sum += root.val;
            curIndex--;
            if(root.left != null) {
                queue.offer(root.left);
                nextIndex++;
            }
            if(root.right != null) {
                queue.offer(root.right);
                nextIndex++;
            }
            if(curIndex == 0) {
                curIndex = nextIndex;
                result.add(sum/nodeSum);
                nodeSum = nextIndex;
                nextIndex = 0;
                sum = 0; 
            }

            
        }
        return result;
    }
}
```

[title]: https://leetcode.com/problems/average-of-levels-in-binary-tree
