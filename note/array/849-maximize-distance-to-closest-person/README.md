# [Maximize Distance to Closest Person][title]

## Description

In a row of `seats`, `1` represents a person sitting in that seat, and `0`
represents that the seat is empty.

There is at least one empty seat, and at least one person sitting.

Alex wants to sit in the seat such that the distance between him and the
closest person to him is maximized.

Return that maximum distance to closest person.

**Example 1:**

```
Input: [1,0,0,0,1,0,1]
Output: 2
Explanation:
If Alex sits in the second open seat (seats[2]), then the closest person has distance 2.
If Alex sits in any other open seat, the closest person has distance 1.
Thus, the maximum distance to the closest person is 2.
```

**Example 2:**

```
Input: [1,0,0,0]
Output: 3
Explanation:
If Alex sits in the last seat, the closest person is 3 seats away.
This is the maximum distance possible, so the answer is 3.
```

**Note:**

1. `1 <= seats.length <= 20000`
2. `seats` contains only 0s or 1s, at least one `0`, and at least one `1`.


**Tags:** Array

**Difficulty:** Easy

## 思路
题意是找到一个能够使乘客与离他最近的人之间的距离达到最大化的座位。大致有三种情况：

1. 0001
2. 1001
3. 1000

首先需要记录间隔最近人的空座数，然后再对三种情况对症下药。

``` java
class Solution {
    public int maxDistToClosest(int[] seats) {
        int res = -1, d = 0;
        for(int x : seats) {
            if(x == 1)
            {
                //说明是开始的位置
                if(res == -1) {
                    res = d;
                }
                else {
                    res = Math.max(res, d/2);   //说明后面的1，则是取中间位置
                }
                d = 1;
            } else {
                d++;
            }

        }
        return Math.max(res, d-1);

    }
}

```

[title]: https://leetcode.com/problems/maximize-distance-to-closest-person
