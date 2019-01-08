# [Island Perimeter][title]

## Description

You are given a map in form of a two-dimensional integer grid where 1 represents land and 0 represents water.

Grid cells are connected horizontally/vertically (not diagonally). The grid is completely surrounded by water, and there is exactly one island (i.e., one or more connected land cells).

The island doesn't have "lakes" (water inside that isn't connected to the water around the island). One cell is a square with side length 1. The grid is rectangular, width and height don't exceed 100. Determine the perimeter of the
island.

**Example:**

```
Input:
[[0,1,0,0],
 [1,1,1,0],
 [0,1,0,0],
 [1,1,0,0]]

Output: 16

Explanation: The perimeter is the 16 yellow stripes in the image below:
```

![pic](https://assets.leetcode.com/uploads/2018/10/12/island.png)

**Tags:** Hash Table

**Difficulty:** Easy

## 思路

题意是算出岛屿的周长。题目和 [Surface Area of 3D Shapes][note-892] 类似。

可以从图片看出，每个方块的有效边取决于四个方向周围有没有方块。这里没有去判断四个方向上是否存在方块，只用到了两个方向，因为有效边的影响是相互的。假设有一个方块 center，若上方存在一个方块 top，则 top 的底边和 center 的顶边都不属于有效边。我们假设有方块 n 个，只需要算出每个方块的顶部和右侧是否存在方块，每存在一个方块，就会在所有方块的边长总和中损失两条边。

``` java
class Solution {
    public int islandPerimeter(int[][] grid) {
        int sum = 0;
        for(int i=0;i<grid.length;i++) {
            for(int j=0;j<grid[0].length;j++) {
                if(grid[i][j] == 1) {
                    sum += 4;
                    if(i<grid.length-1 && grid[i+1][j] == 1) {
                        sum -= 2;
                    }
                    if(j<grid[0].length-1 && grid[i][j+1] == 1) {
                        sum -= 2;
                    }
                }
            }
        }
        return sum;
    }
}
```

[title]: https://leetcode.com/problems/island-perimeter
[note-892]:  https://github.com/gcyml/leetcode-record-java/tree/master/note/math/892-surface-area-of-3d-shapes
