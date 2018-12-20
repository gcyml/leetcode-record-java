# [1-bit and 2-bit Characters][title]

## Description

We have two special characters. The first character can be represented by one bit `0`. The second character can be represented by two bits (`10` or `11`).

Now given a string represented by several bits. Return whether the last character must be a one-bit character or not. The given string will always end with a zero.

**Example 1:**

```
Input:
bits = [1, 0, 0]
Output: True
Explanation:
The only way to decode it is two-bit character and one-bit character. So the last character is one-bit character.
```

**Example 2:**

```
Input:
bits = [1, 1, 1, 0]
Output: False
Explanation:
The only way to decode it is two-bit character and two-bit character. So the last character is NOT one-bit character.
```

**Note:**

1. `1 <= len(bits) <= 1000`.
2. `bits[i]` is always `0` or `1`.

**Tags:** Array

**Difficulty:** Easy

## 思路

由题意可知，第一个字符为 `1` 时，其连续的两个元素必定为 `2 比特字符`。可通过此特性正确分组出 `1 比特字符` 和 `2 比特字符`。线性遍历时，当前元素若为 `1`，则跳过下一元素，`i`自增。若最后一个字符为 `2 比特字符`，则 `i == bits.length`。

``` java
class Solution {
    public boolean isOneBitCharacter(int[] bits) {
        int i = 0;
        for(;i<bits.length-1;i++) {
            if(bits[i] == 1) {
                i++;
            }
        }
        return i != bits.length;
    }
}
```

[title]: https://leetcode.com/problems/1-bit-and-2-bit-characters
