# [Two Sum II - Input array is sorted][title]

## Description

Given an array of integers that is already ***sorted in ascending order***, find two numbers such that they add up to a specific target number.

The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2.

**Note:**

* Your returned answers (both index1 and index2) are not zero-based.
* You may assume that each input would have exactly one solution and you may not use the same element twice.

**Example:**

```
Input: numbers = [2,7,11,15], target = 9
Output: [1,2]
Explanation: The sum of 2 and 7 is 9. Therefore index1 = 1, index2 = 2.
```

**Tags:** Array, Two Pointers, Binary Search

**Difficulty:** Easy

## 思路

``` java
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int [] res = new int[2];
        int[] dp = new int[numbers.length];
        for(int i=0;i<numbers.length;i++) {
            for(int j = i-1;j>=0;j--) {
                if(dp[j] == numbers[i]) {
                    res[0] = j+1;
                    res[1] = i+1;
                    return res;
                }
            }
            dp[i] = target - numbers[i];

        }
        return res;

    }
}
```

[title]: https://leetcode.com/problems/two-sum-ii-input-array-is-sorted
