# [Smallest Range I][title]

## Description

Given an array `A` of integers, for each integer `A[i]` we may choose any `x` with `-K <= x <= K`, and add `x` to `A[i]`.

After this process, we have some array `B`.

Return the smallest possible difference between the maximum value of `B` and the minimum value of `B`.

**Example 1:**

```
Input: A = [1], K = 0
Output: 0
Explanation: B = [1]
```

**Example 2:**

```
Input: A = [0,10], K = 2
Output: 6
Explanation: B = [2,8]
```

**Example 3:**

```
Input: A = [1,3,6], K = 3
Output: 0
Explanation: B = [3,3,3] or B = [4,4,4]
```

**Note:**

1. `1 <= A.length <= 10000`
2. `0 <= A[i] <= 10000`
3. `0 <= K <= 10000`

**Tags:** Math

**Difficulty:** Easy

## 思路

题意是给出一个整型数组，以及整数 `k`，可以给数组任意一个元素加上值 x， `-k < x < k`。对元素进行处理后，使得元素的最大值和最小值的尽可能小。
先找出最大值和最小值，如果两值相差超过了 2*k，则必然无法使差值减小为 0，最终结果只能是 `diff - 2*k`。

``` java
class Solution {
    public int smallestRangeI(int[] A, int K) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int a : A) {
            max = Math.max(a, max);
            min = Math.min(a, min);
        }
        return max - min > K*2 ? max - min - 2 * K : 0;
    }
}
```

[title]: https://leetcode.com/problems/smallest-range-i
