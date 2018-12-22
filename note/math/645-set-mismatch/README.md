# [Set Mismatch][title]

## Description

The set `S` originally contains numbers from 1 to `n`. But unfortunately, due
to the data error, one of the numbers in the set got duplicated to **another**
number in the set, which results in repetition of one number and loss of
another number.

Given an array `nums` representing the data status of this set after the
error. Your task is to firstly find the number occurs twice and then find the
number that is missing. Return them in the form of an array.

**Example 1:**  

```
Input: nums = [1,2,2,4]
Output: [2,3]
```

**Note:**  

1. The given array size will in the range [2, 10000].
2. The given array's numbers won't have any order.

**Tags:** Hash Table, Math

**Difficulty:** Easy

## 思路

题意是给出一段原定 1 到 n 的数组（未排序），但数据错误，导致有一个数重复输入了一次。找出重复的数字以及缺失的值。思路很简单，只要创建一个长度为 n 的数组记录频数，索引表示对应值，返回频数为 2 和频数为 1 的索引即可。这里用了两次遍历，第一次遍历记录频数，若频数超过 1 则找到了重复数。第二次遍历频数数组，找出频数为 0 的数。

``` java
class Solution {
    public int[] findErrorNums(int[] nums) {
        int[] res = new int[2];
        boolean[] tmp = new boolean[nums.length];
        for(int i = 0;i<nums.length;i++) {
            if(!tmp[nums[i]-1]) {
                tmp[nums[i]-1] = true;
            } else {
                res[0] = nums[i];
            }
        }
        for(int i = 0;i<tmp.length;i++) {
            if(!tmp[i]) {
                res[1] = i+1;
                break;
            }
        }
        return res;
    }
}
```

[title]: https://leetcode.com/problems/set-mismatch
