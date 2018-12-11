# [Magic Squares In Grid][title]

## Description

A 3 x 3 magic square is a 3 x 3 grid filled with distinct numbers **from 1 to
9** such that each row, column, and both diagonals all have the same sum.

Given an `grid` of integers, how many 3 x 3 "magic square" subgrids are there?
(Each subgrid is contiguous).


**Example 1:**
```
Input: [[4,3,8,4],
        [9,5,1,9],
        [2,7,6,2]]
Output: 1
Explanation:
The following subgrid is a 3 x 3 magic square:
438
951
276

while this one is not:
384
519
762

In total, there is only one magic square inside the given grid.
```

**Note:**

1. `1 <= grid.length <= 10`
2. `1 <= grid[0].length <= 10`
3. `0 <= grid[i][j] <= 15`


**Tags:** Array

**Difficulty:** Easy

## 思路
3 x 3 的幻方是一个填充有从 1 到 9 的不同数字的 3 x 3 矩阵，其中每行，每列以及两条对角线上的各数之和都相等。解题思路是遍历矩阵，以该点为中心，判断以当前点为中心的 3*3矩阵是否为幻方。难点在于写出判断函数。

``` java
class Solution {
    public int numMagicSquaresInside(int[][] grid) {
        int row = grid.length, col = grid[0].length;
        if(row < 3 || col <3 ){
            return 0;
        }

        int count = 0;
        for(int i= 0;i<=row-3;i++) {
            for(int j = 0;j<=col-3;j++) {
                if(helper(grid, i, j)) {
                    count++;
                }
            }
        }
        return count;
    }
    public boolean helper(int[][] grid, int r, int c){
        for(int i =r;i<r+3;i++) {
            for(int j =c;j<c+3;j++) {
                if(grid[i][j] <1 || grid[i][j] > 9) {
                    return false;
                }
            }
        }
        int sum = grid[r][c] + grid[r+1][c+1] + grid[r+2][c+2];
        return sum == grid[r][c] + grid[r+1][c] + grid[r+2][c] && sum == grid[r][c] + grid[r][c+1] + grid[r][c+2] && sum == grid[r+2][c] + grid[r+2][c+1] + grid[r+2][c+2] && sum == grid[r][c+2] + grid[r+1][c+2] + grid[r+2][c+2] && sum == grid[r][c+2] + grid[r+1][c+1] + grid[r+2][c];
    }
}
```

[title]: https://leetcode.com/problems/magic-squares-in-grid
