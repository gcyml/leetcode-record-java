# [Transpose Matrix][title]

## Description

Given a matrix A, return the transpose of A.

The transpose of a matrix is the matrix flipped over it's main diagonal, switching the row and column indices of the matrix.

**Example 1:**

```
Input: [[1,2,3],[4,5,6],[7,8,9]]
Output: [[1,4,7],[2,5,8],[3,6,9]]
```

**Example 2:**

```
Input: [[1,2,3],[4,5,6]]
Output: [[1,4],[2,5],[3,6]]
```

**Note:**

1. `1 <= A.length <= 1000`
2. `1 <= A[0].length <= 1000`

**Tags:** Array

**Difficulty:** Easy

## 思路

题意是转置矩阵，比较简单，把行索引和列索引互换即可。

``` java
class Solution {
    public int[][] transpose(int[][] A) {
        int row = A.length;
        int col = A[0].length;
        int[][] res = new int[col][row];
        for(int i = 0;i<row;i++) {
             for(int j = 0;j<col;j++) {
                res[j][i] = A[i][j];
             }
        }
         return res;
    }
}
```

[title]: https://leetcode.com/problems/transpose-matrix
