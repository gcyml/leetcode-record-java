# [Single Number][title]

## Description

Given a **non-empty**  array of integers, every element appears _twice_ except for one. Find that single one.

**Note:**

Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

**Example 1:**

```
Input: [2,2,1]
Output: 1
```

**Example 2:**

```
Input: [4,1,2,1,2]
Output: 4
```

**Tags:** Hash Table, Bit Manipulation

**Difficulty:** Easy

## 思路 0

题意是找出只出现一次的元素。

第一种解法是对元素排序后，然后从索引 0 开始依次比较前后两个元素是否相等，若不相等，则该元素只出现了一次。

``` java
class Solution {
    public int singleNumber(int[] nums) {
        Arrays.sort(nums);
        for(int i =0;i<nums.length-1;i+=2) {
            if(nums[i] != nums[i+1]) {
                return nums[i];
            }
        }
        return nums[nums.length-1];
    }
}
```

## 思路 1

第二种解法是由于数组中除了只出现一次的元素以外都是出现了两次。创建一个变量，对数组中所有值取异或。由于相等的值取异或只会等于 0，因此最后异或的结果即为只出现一次的值。

``` java
class Solution {
    public int singleNumber(int[] nums) {
        int a = 0;
        for(int i =0; i<nums.length;i++){
            a ^= nums[i];
        }
        return a;
    }
}
```

[title]: https://leetcode.com/problems/single-number
