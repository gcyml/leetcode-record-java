# [Path Sum III][title]

## Description

You are given a binary tree in which each node contains an integer value.

Find the number of paths that sum to a given value.

The path does not need to start or end at the root or a leaf, but it must go downwards (traveling only from parent nodes to child nodes).

The tree has no more than 1,000 nodes and the values are in the range -1,000,000 to 1,000,000.

**Example:**

```
root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8

      10
     /  \
    5   -3
   / \    \
  3   2   11
 / \   \
3  -2   1

Return 3. The paths that sum to 8 are:

1.  5 -> 3
2.  5 -> 2 -> 1
3. -3 -> 11
```

**Tags:** Tree

**Difficulty:** Easy

## 思路

这一题和 [Path Sum][note-112] 的区别在于不限起始节点和结束节点。可以用递归的方法，以当前节点为起点，不限终点，找出符合条件的路径。而后再向下递归，找出以左子树为起点和右子树为起点，同理。最后的路径总和数即为结果。

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
    public int pathSum(TreeNode root, int sum) {
        if(root == null) return 0;
        return helper(root, 0, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }
    int helper(TreeNode root, int pre, int sum) {
        if(root == null) {
            return 0;
        }
        int cur = pre + root.val;
        return (cur == sum? 1: 0) + helper(root.left, cur, sum) + helper(root.right, cur, sum);
    }
}
```

[title]: https://leetcode.com/problems/path-sum-iii
[note-112]: https://github.com/gcyml/leetcode-record-java/tree/master/note/tree/112-path-sum
