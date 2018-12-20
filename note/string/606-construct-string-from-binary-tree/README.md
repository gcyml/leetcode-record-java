# [Construct String from Binary Tree][title]

## Description

You need to construct a string consists of parenthesis and integers from a binary tree with the preorder traversing way.

The null node needs to be represented by empty parenthesis pair "()". And you
need to omit all the empty parenthesis pairs that don't affect the one-to-one
mapping relationship between the string and the original binary tree.

**Example 1:**

```
Input: Binary tree: [1,2,3,4]
           1
         /   \
        2     3
       /
      4

Output: "1(2(4))(3)"

Explanation: Originallay it needs to be "1(2(4)())(3()())",
And it will be "1(2(4))(3)".
```

**Example 2:**

```
Input: Binary tree: [1,2,3,null,4]
           1
         /   \
        2     3
         \
          4

Output: "1(2()(4))(3)"

Explanation: Almost the same as the first example,
except we can't omit the first parenthesis pair to break the one-to-one mapping relationship between the input and the output.
```

**Tags:** String, Tree

**Difficulty:** Easy

## 思路

题意是用前序遍历将一个二叉树转换成一个由括号和整数组成的字符串。首先可以看出根节点是不需要用括号包住，其余都需要。前序遍历用递归遍历。需要注意的是要省略去不影响表达的空括号，可以看出，前序遍历的情况下，缺失空的右节点并不会影响二叉树表达。因此在这里，若碰到左节点为空，而右节点不为空时，则添加空括号。而空白的右节点，不做任何操作。

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
    StringBuilder sb = new StringBuilder();
    public String tree2str(TreeNode t) {
        if(t == null) {
            return "";
        }
        helper(t);
        String res = sb.toString();
        return res.substring(1, res.length()-1);
    }
    void helper(TreeNode t){
        if(t == null){
            return;
        }
        sb.append("(" + t.val);
        if(t.left == null && t.right != null){
            sb.append("()");
        } else {
            helper(t.left);

        }
        helper(t.right);
        sb.append(")");
    }
}
```

[title]: https://leetcode.com/problems/construct-string-from-binary-tree
