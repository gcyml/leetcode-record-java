# [Toeplitz Matrix][title]

## Description

A matrix is ***Toeplitz*** if every diagonal from top-left to bottom-right has the same element.

Now given an M x N matrix, return True if and only if the matrix is ***Toeplitz***.

**Example 1:**

```
Input:
matrix = [
  [1,2,3,4],
  [5,1,2,3],
  [9,5,1,2]
]
Output: True
Explanation:
In the above grid, the diagonals are:
"[9]", "[5, 5]", "[1, 1, 1]", "[2, 2, 2]", "[3, 3]", "[4]".
In each diagonal all elements are the same, so the answer is True.
```

**Example 2:**

```
Input:
matrix = [
  [1,2],
  [2,2]
]
Output: False
Explanation:
The diagonal "[1, 2]" has different elements.
```

**Follow up:**

1. What if the matrix is stored on disk, and the memory is limited such that you can only load at most one row of the matrix into the memory at once?
2. What if the matrix is so large that you can only load up a partial row into the memory at once?

**Note:**

1. `matrix` will be a 2D array of integers.
2. `matrix` will have a number of rows and columns in range `[1, 20]`.
3. `matrix[i][j]` will be integers in range `[0, 99]`.

**Tags:** Array

**Difficulty:** Easy

## 思路

判断矩阵是否为托普利茨矩阵。如果一个矩阵的每一方向由左上到右下的对角线上具有相同元素，那么这个矩阵是托普利茨矩阵。下面的解法是通过遍历列来判断中心对角线右侧是否符合条件，遍历行来判断中心对角线左侧是否符合条件。

``` java
class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) {
        int col = matrix[0].length;
        int row = matrix.length;
        for(int i =0;i<col-1;i++) {
            int curRow = 1;
            for(int j=i+1;j<col;j++) {
                if(curRow < row && matrix[0][i] != matrix[curRow][j]) {
                    return false;
                }
                curRow++;
            }
        }
        for(int i =0;i<row-1;i++) {
            int curCol = 1;
            for(int j=i+1;j<row;j++) {
                if(curCol < col && matrix[i][0] != matrix[j][curCol]) {
                    return false;
                }
                curCol++;
            }
        }
        return true;
    }
}
```

[title]: https://leetcode.com/problems/toeplitz-matrix
