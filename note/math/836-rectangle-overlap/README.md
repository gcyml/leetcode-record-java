# [Rectangle Overlap][title]

## Description

A rectangle is represented as a list `[x1, y1, x2, y2]`, where `(x1, y1)` are the coordinates of its bottom-left corner, and `(x2, y2)` are the coordinates of its top-right corner.

Two rectangles overlap if the area of their intersection is positive.  To be clear, two rectangles that only touch at the corner or edges do not overlap.

Given two (axis-aligned) rectangles, return whether they overlap.

**Example 1:**

```
Input: rec1 = [0,0,2,2], rec2 = [1,1,3,3]
Output: true
```

**Example 2:**

```
Input: rec1 = [0,0,1,1], rec2 = [1,0,2,1]
Output: false
```

**Notes:**

1. Both rectangles `rec1` and `rec2` are lists of 4 integers.
2. All coordinates in rectangles will be between `-10^9` and `10^9`.

**Tags:** Math

**Difficulty:** Easy

## 思路

给出两个矩形的左上角和右下角的顶点坐标，判断两个矩形是否重叠。若要满足两矩形不重叠，有下面两种情况：

1. 其中一个矩形左上角的 x 坐标大于等于右下角另一个矩形的 x 坐标；
2. 其中一个矩形左上角的 y 坐标大于等于右下角另一个矩形的 y 坐标；

``` java
class Solution {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        return !(rec1[0] >= rec2[2] || rec1[1] >= rec2[3] || rec2[0] >= rec1[2] || rec2[1] >= rec1[3]);
    }
}
```

[title]: https://leetcode.com/problems/rectangle-overlap
