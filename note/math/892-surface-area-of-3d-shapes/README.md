# [Surface Area of 3D Shapes][title]

## Description

On a `N * N` grid, we place some `1 * 1 * 1` cubes.

Each value `v = grid[i][j]` represents a tower of `v` cubes placed on top of grid cell `(i, j)`.

Return the total surface area of the resulting shapes.

**Example 1:**

```
Input: [[2]]
Output: 10
```

**Example 2:**

```
Input: [[1,2],[3,4]]
Output: 34
```

**Example 3:**

```
Input: [[1,0],[0,2]]
Output: 16
```

**Example 4:**

```
Input: [[1,1,1],[1,0,1],[1,1,1]]
Output: 32
```

**Example 5:**

```
Input: [[2,2,2],[2,1,2],[2,2,2]]
Output: 46
```

**Note:**

* `1 <= N <= 50`
* `0 <= grid[i][j] <= 50`

**Tags:** Math, Geometry

**Difficulty:** Easy

## 思路

题意是求出在网格中放置格子的总面积。先从一个格子来分析。若单单只算一个格子，不受周围格子方块影响，面积是方块数 * 4 再加上下两个面。而网格中的总面积是会受到周围格子影响的，因此只要求出受影响而减少的那些面，用前面得到的面积总和减去受影响的面积，即等于实际总面积。
假设当前格子有四个方块，其左侧格子有两个方块，则受影响减去的则是两个面。左侧受影响的面的个数与两个格子中方块最少的格子有关，由于其方块数少，相邻的面被阻挡。
对应当前格子与相邻的上侧格子，其受影响的面积也是决定于两个格子中方块最少的格子。
在这里并不需要去计算四个方向上的所有受影响的面，由于有一面受影响，对应的必然也有另外一个格子的面受影响，因此只需要算出每一个格子中的左侧和上侧收影响的面，然后乘 2，用总和减去。即得到结果。

``` java
class Solution {
    public int surfaceArea(int[][] grid) {
        int sum = 0;
        for(int i = 0; i<grid.length;i++){
            for(int j = 0; j<grid[0].length;j++){
                int cubeNum = grid[i][j];
                if(cubeNum > 0) {
                    sum += cubeNum * 4 + 2;
                    if(i > 0) {
                        sum -= Math.min(grid[i-1][j], grid[i][j])*2;
                    }
                    if(j > 0) {
                        sum -= Math.min(grid[i][j-1], grid[i][j])*2;
                    }
                } 
            }
        }
        return sum;
    }
}
```

[title]: https://leetcode.com/problems/surface-area-of-3d-shapes
