# [K-diff Pairs in an Array][title]

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

## 思路 0

题意是给定一个整数数组和一个整数 `k`, 你需要在数组里找到不同的 `k-diff` 数对。这里将 k-diff 数对定义为一个整数对 (i, j), 其中 i 和 j 都是数组中的数字，且两数之差的绝对值是 `k`。第一种方法是使用键值对，而后找出数组对 `pair(a,b)`，由 `a - b = k`从 `a` 找到 `b`。此外，由于题中要求数值对唯一，需要从map中删去 `b`。

``` java
public class Solution {
    public int findPairs(int[] nums, int k) {
        if(nums == null || nums.length == 0 || k < 0) return 0;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i < nums.length; ++i) {
            map.put(nums[i], i);
        }
        int res = 0;
        for(int i = 0; i < nums.length; ++i) {
            if(map.containsKey(nums[i] + k) && map.get(nums[i] + k) != i) {
                map.remove(nums[i] + k);
                res++;
            }
        }
        return res;
    }
}
```

## 思路1

另外一种较高效的做法是先对数组进行排序，而后使用双指针。遍历排序后的数组，然后在当前数字之后找第一个和当前数之差不小于 `k` 的数字，若这个数字和当前数字之差正好为 `k`，那么结果 `res` 自增1，然后遍历后面的数字去掉重复数字。

```java
class Solution {
    public int findPairs(int[] nums, int k) {
        int res = 0, j = 0, n = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i < n; ++i) {
            j = Math.max(j, i + 1);
            while (j < n && nums[j] - nums[i] < k) ++j;
            if (j < n && nums[j] - nums[i] == k) ++res;
            while (i < n - 1 && nums[i] == nums[i + 1]) ++i;
        }
        return res;
    }
}
```

[title]: https://leetcode.com/problems/k-diff-pairs-in-an-array
