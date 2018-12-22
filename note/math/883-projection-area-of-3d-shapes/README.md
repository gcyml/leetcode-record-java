# [Projection Area of 3D Shapes][title]

## Description

On a `N * N` grid, we place some `1 * 1 * 1` cubes that are axis-aligned with the x, y, and z axes.

Each value `v = grid[i][j]` represents a tower of `v` cubes placed on top of grid cell `(i, j)`.

Now we view the  _projection_  of these cubes onto the xy, yz, and zx planes.

A projection is like a shadow, that maps our 3 dimensional figure to a 2 dimensional plane.

Here, we are viewing the "shadow" when looking at the cubes from the top, the front, and the side.

Return the total area of all three projections.

**Example 1:**

```
Input: [[2]]
Output: 5
```

**Example 2:**

```
Input: [[1,2],[3,4]]
Output: 17
Explanation:
Here are the three projections ( "shadows") of the shape made with each axis-aligned plane.
```

![pic](https://s3-lc-upload.s3.amazonaws.com/uploads/2018/08/02/shadow.png)

**Example 3:**

```
Input: [[1,0],[0,2]]
Output: 8
```

**Example 4:**

```
Input: [[1,1,1],[1,0,1],[1,1,1]]
Output: 14
```

**Example 5:**

```
Input: [[2,2,2],[2,1,2],[2,2,2]]
Output: 21
```

**Note:**

* `1 <= grid.length = grid[0].length <= 50`
* `0 <= grid[i][j] <= 50`


**Tags:** Math

**Difficulty:** Easy

## 思路

分析题目可发现，侧面的投影相当于从 x 轴每一行的最高点集合而成，正面的投影相当于从 y 轴每一列的最高点集合，而顶点的投影则是占有立方体的格子数。因此解法就是找出每一行的最大值和每一列的最大值，以及占有立方体的格子数，三个总和就是答案。

``` java
class Solution {
    public int projectionArea(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int res = 0;
        for(int i = 0;i< row;i++) {
            int colMax = 0;
            for(int j = 0;j<col;j++) {
                colMax = Math.max(grid[i][j], colMax);
            }
            res += colMax;
        }
        for(int i = 0;i< col;i++) {
            int rowMax = 0;
            for(int j = 0;j<row;j++) {
                rowMax = Math.max(grid[j][i], rowMax);
                if(grid[j][i] != 0) {
                    res++;
                }
            }
            res += rowMax;
        }
        return res;
    }
}
```

[title]: https://leetcode.com/problems/projection-area-of-3d-shapes
