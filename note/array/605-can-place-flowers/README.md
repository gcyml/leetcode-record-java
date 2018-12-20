# [Can Place Flowers][title]

## Description

Suppose you have a long flowerbed in which some of the plots are planted and some are not. However, flowers cannot be planted in adjacent plots - they would compete for water and both would die.

Given a flowerbed (represented as an array containing 0 and 1, where 0 means empty and 1 means not empty), and a number **n**, return if n new flowers can be planted in it without violating the no-adjacent-flowers rule.

**Example 1:**

```
Input: flowerbed = [1,0,0,0,1], n = 1
Output: True
Example 2:
Input: flowerbed = [1,0,0,0,1], n = 2
Output: False
```

**Note:**

1. The input array won't violate no-adjacent-flowers rule.
2. The input array size is in the range of [1, 20000].
3. **n** is a non-negative integer which won't exceed the input array size.

**Tags:** Array

**Difficulty:** Easy

## 思路

思路很简单，写个方法判断左右两侧是否种植了花，若没有则在此种下花。

``` java
class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        for(int i =0;i<flowerbed.length;i++) {
            if(helper(flowerbed, i)) {
                flowerbed[i] = 1;
                if(--n <=0) {
                    break;
                }
            }
        }
        return n<=0;
    }
    public boolean helper(int[] flowerbed, int i) {
        if(flowerbed[i] == 0) {
            if(i-1 >= 0 && i+1 < flowerbed.length) {
                return flowerbed[i-1] == 0 && flowerbed[i+1] == 0;
            }
            if(i-1 < 0 && i+1 < flowerbed.length) {
                return flowerbed[i+1] == 0;
            }
            if(i-1 >= 0 && i+1 >= flowerbed.length) {
                return flowerbed[i-1] == 0;
            }
            return true;
        } else {
            return false;
        }
    }
}
```

[title]: https://leetcode.com/problems/can-place-flowers
