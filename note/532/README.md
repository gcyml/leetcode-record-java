# [Max Consecutive Ones][title]

## Description

Given an array of integers and an integer **k**, you need to find the number of **unique** k-diff pairs in the array. Here a k-diff pair is defined as an integer pair (i, j), where **i** and **j** are both numbers in the array and their [absolute difference](https://en.wikipedia.org/wiki/Absolute_difference) is **k**.

**Example 1:**

```
Input: [3, 1, 4, 1, 5], k = 2
Output: 2
Explanation: There are two 2-diff pairs in the array, (1, 3) and (3, 5).
Although we have two 1s in the input, we should only return the number of unique pairs.
```

**Example 2:**

```
Input:[1, 2, 3, 4, 5], k = 1
Output: 4
Explanation: There are four 1-diff pairs in the array, (1, 2), (2, 3), (3, 4) and (4, 5).
```

**Example 3:**

```
Input: [1, 3, 1, 5, 4], k = 0
Output: 1
Explanation: There is one 0-diff pair in the array, (1, 1).
```

**Note:**
1. The pairs (i, j) and (j, i) count as the same pair.
2. The length of the array won't exceed 10,000.
3. All the integers in the given input belong to the range: [-1e7, 1e7].
**Tags:** Array

**Difficulty:** Easy, Two Pointers

## 思路

题意是给定一个整数数组和一个整数 `k`, 你需要在数组里找到不同的 `k-diff` 数对。这里将 k-diff 数对定义为一个整数对 (i, j), 其中 i 和 j 都是数组中的数字，且两数之差的绝对值是 k.此题比较简单，遍历即可。

```java
class Solution {
    public int findPairs(int[] nums, int k) {
        if(nums == null || nums.length < 2 || k < 0) {
            return 0;
        }
        Arrays.sort(nums);
        int res = 0;
        int low = 0, fast = 1;
        while(fast <nums.length){
            int firNum = nums[low];
            int secNum = nums[fast];
            if(secNum - firNum < k) {
                fast++;
            } else if(secNum - firNum > k) {
                low++;
            } else{
                res++;
                while(low<nums.length && nums[low]==firNum){
                    low++;
                }
                while(fast < nums.length && nums[fast]==secNum){
                    fast++;
                }
            }
            if(fast==low){
                fast++;
            }
        }
        return res;
    }
}
```


[title]: https://leetcode.com/problems/k-diff-pairs-in-an-array
