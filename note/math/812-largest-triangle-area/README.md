# [Largest Triangle Area][title]

## Description

You have a list of points in the plane. Return the area of the largest triangle that can be formed by any 3 of the points.

**Example:**

```
Input: points = [[0,0],[0,1],[1,0],[0,2],[2,0]]
Output: 2
Explanation:
The five points are show in the figure below. The red triangle is the largest.
```

![pic](https://s3-lc-upload.s3.amazonaws.com/uploads/2018/04/04/1027.png)

**Notes:**

* `3 <= points.length <= 50`.
* No points will be duplicated.
* `-50 <= points[i][j] <= 50`.
* Answers within `10^-6` of the true value will be accepted as correct.

**Tags:** Math

**Difficulty:** Easy

## 思路

题意是给出一个二位矩阵，返回矩阵中由三个点组成的面积最大的三角形。三层循环，暴力破解。

``` java
class Solution {
    public double largestTriangleArea(int[][] points) {
        double max = Integer.MIN_VALUE;
        for(int i = 0;i<points.length;i++) {
            for(int j = 0;j<points.length;j++) {
                for(int k = 0;k<points.length;k++) {
                    max = Math.max(max, triangleArea(points[i][0], points[i][1], points[j][0], points[j][1], points[k][0], points[k][1]));
                }
            }
        }
        return max;
    }
    double triangleArea(int x1, int y1, int x2, int y2, int x3, int y3) {
        return 0.5 * Math.abs((x2 * y3 - x3 * y2) - (x1 * y3 - x3 * y1) + (x1 * y2 - x2 * y1));
    }
}
```

[title]: https://leetcode.com/problems/largest-triangle-area
