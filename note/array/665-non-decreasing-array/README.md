# [Non-decreasing Array][title]

## Description

Given two integers n and k, you need to construct a list which contains n different positive integers ranging from 1 to n and obeys the following requirement:
Suppose this list is [a1, a2, a3, ... , an], then the list [|a1 - a2|, |a2 - a3|, |a3 - a4|, ... , |an-1 - an|] has exactly k distinct integers.

If there are multiple answers, print any of them.

Example 1:
Input: n = 3, k = 1
Output: [1, 2, 3]
Explanation: The [1, 2, 3] has three different positive integers ranging from 1 to 3, and the [1, 1] has exactly 1 distinct integer: 1.
Example 2:
Input: n = 3, k = 2
Output: [1, 3, 2]
Explanation: The [1, 3, 2] has three different positive integers ranging from 1 to 3, and the [2, 1] has exactly 2 distinct integers: 1 and 2.
Note:
The n and k are in the range 1 <= k < n <= 10^4.

**Tags:** Array

**Difficulty:** Easy

## 思路

题意是通过修改一个元素使得数组变成非递减数组。解法是遍历数组，设当前元素为 `nums[i]`，若小于前一元素，即 `nums[i] < nums[i-1]`，则替换元素。替换的策略有两种：1是替换前一元素变成当前元素，2是当前元素替换成前一元素。这两种策略采用哪一种需要考虑前面的数字的前面的数字，即 `nums[i-2]`，存在两种情况：

1. `nums[i-2] <= nums[i] < nums[i-1]`
2. `nums[i-2] > nums[i] < nums[i-1]`

要保证更改后数组为非递减数组，即满足 `nums[i-2] <= nums[i-1] <= nums[i]`。
因此，第一种情况下，则必须要采取第一种策略，即 `nums[i-1] = nums[i]` 才能保证此更改后数组为非递减数组；而在第二种情况中，则需要使得 `nums[i] = nums[i-1]`。

``` java
class Solution {
    public boolean checkPossibility(int[] nums) {
        int modifyCount = 0;
        for(int i = 1;i<nums.length && modifyCount <= 1;i++) {
            if(nums[i-1] > nums[i]){
                modifyCount++;
                if(i-2 < 0 || nums[i-2] <= nums[i])
                    nums[i-1] = nums[i];
                else
                    nums[i] = nums[i-1];
            }
        }
        return modifyCount <= 1;
    }
}
```

[title]: https://leetcode.com/problems/non-decreasing-array
