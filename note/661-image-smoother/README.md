# [Image Smoother][title]

## Description

Given a 2D integer matrix M representing the gray scale of an image, you need to design a smoother to make the gray scale of each cell becomes the average gray scale (rounding down) of all the 8 surrounding cells and itself. If a cell has less than 8 surrounding cells, then use as many as you can.

**Example 1:**

```
Input:
[[1,1,1],
 [1,0,1],
 [1,1,1]]
Output:
[[0, 0, 0],
 [0, 0, 0],
 [0, 0, 0]]
Explanation:
For the point (0,0), (0,2), (2,0), (2,2): floor(3/4) = floor(0.75) = 0
For the point (0,1), (1,0), (1,2), (2,1): floor(5/6) = floor(0.83333333) = 0
For the point (1,1): floor(8/9) = floor(0.88888889) = 0
```

**Note:**

1. The value in the given matrix is in the range of [0, 255].
2. The length and width of the given matrix are in the range of [1, 150].

**Tags:** Array

**Difficulty:** Easy

## 思路

题意大致是把一个二维数组的元素重新赋值为它周边8个元素以及自身大小和的平均值。

``` java
class Solution {
    public int[][] imageSmoother(int[][] M) {
        int row = M.length;
        int col = M[0].length;
        int[][] res = new int[row][col];
        for(int i = 0; i< row;i++) {
            for(int j = 0; j< col;j++) {
                 res[i][j] = helper(M, i, j, true);
            }
        }
        return res;
    }
    // 获取周边值均值
    public int helper(int[][] m, int i, int j, boolean isCenter) {
        if(i < 0 || j < 0 || i>= m.length || j>=m[0].length) {
            return -1;
        }
        int res = 0;
        int count = 0;
        int sum = 0;
        if(isCenter) {
            for(int r = i-1; r <= i+1; r++) {
                for(int c = j-1; c <= j+1; c++) {
                    int tmp = helper(m, r, c, false);
                    if(tmp != -1) {
                        count++;
                        sum += tmp;

                    }
                }
            }
            return sum/count;
        } else {
            return m[i][j];
        }
    }
}
```



[title]: https://leetcode.com/problems/image-smoother
