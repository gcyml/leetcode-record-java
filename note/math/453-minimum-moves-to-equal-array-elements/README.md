# [Minimum Moves to Equal Array Elements][title]

## Description

Given a **non-empty** integer array of size _n_ , find the minimum number of
moves required to make all array elements equal, where a move is incrementing
_n_ \- 1 elements by 1.

**Example:**

```
Input:
[1,2,3]

Output:
3

Explanation:
Only three moves are needed (remember each move increments two elements):

[1,2,3]  =>  [2,3,3]  =>  [3,4,3]  =>  [4,4,4]
```

**Tags:** Math

**Difficulty:** Easy

## 思路

每移动一次数，使得其他数 +1，类似于每次移动一次，就有一个数减 1。题目就变成了，使得数组中所有除了最小值以外，减少到等于最小值的次数总和。这个值等于 `sum - min * size`。

``` java
class Solution {
    public int minMoves(int[] nums) {
        // n-1 个数+1使得最后相等，等价于每次移动一个数减1，使得最后相等
        int mn = Integer.MAX_VALUE, sum = 0, res = 0;
        for (int num : nums) {
            mn = Math.min(mn, num);
            sum += num;
        }
        return sum - mn * nums.length;
    }
}
```

[title]: https://leetcode.com/problems/minimum-moves-to-equal-array-elements
