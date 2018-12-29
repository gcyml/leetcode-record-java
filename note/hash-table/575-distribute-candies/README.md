# [Distribute Candies][title]

## Description

Given an integer array with **even** length, where different numbers in this
array represent different **kinds** of candies. Each number means one candy of
the corresponding kind. You need to distribute these candies **equally** in
number to brother and sister. Return the maximum number of **kinds** of
candies the sister could gain.

**Example 1:**  
        

**Example 2:**  
        

**Note:**

  1. The length of the given array is in range [2, 10,000], and will be even.
  2. The number in given array is in range [-100,000, 100,000].


**Tags:** Hash Table

**Difficulty:** Easy

## 思路

``` java
class Solution {
    public int distributeCandies(int[] candies) {
        HashSet<Integer> set = new HashSet<>();
        int half = candies.length/2;
        for(int candie: candies) {
            set.add(candie);
            if(set.size() > half) {
                return half;
            }
        }
        return set.size();
    }
}
```

[title]: https://leetcode.com/problems/distribute-candies