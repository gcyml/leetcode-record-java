# [Buddy Strings][title]

## Description

Given two strings `A` and `B` of lowercase letters, return `true` if and only if we can swap two letters in `A` so that the result equals `B`.

**Example 1:**

```
Input: A = "ab", B = "ba"
Output: true
```

**Example 2:**

```
Input: A = "ab", B = "ab"
Output: false
```

**Example 3:**

```
Input: A = "aa", B = "aa"
Output: true
```

**Example 4:**

```
Input: A = "aaaaaaabc", B = "aaaaaaacb"
Output: true
```

**Example 5:**

```
Input: A = "", B = "aa"
Output: false
```

**Note:**

1. `0 <= A.length <= 20000`
2. `0 <= B.length <= 20000`
3. `A` and `B` consist only of lowercase letters.

**Tags:** String

**Difficulty:** Easy

## 思路

题意是两个字符串 `A` 和 `B`, 判断 `A` 是否可以通过交换 `A` 的两个字母得到 `B`。

要满足条件，首先两个字符串的长度必须要相等。然后，会分为两种情况：

第一种情况，A 和 B 相等。由于 A 和 B 全等，要使得 A 交换字母得到 B，也就是 A 如何交换字母而不改变自身。答案是交换两个相同的字母。

第二种情况，A 和 B 不相等。要实现 A 可以通过交换两个字母得到 `B`，首先 A 和 B 应该只有两处不同，且两处不同应该是交叉相等的，即 A 在第一处不同的上的字母要等于 B 在第二处不同上的字母。示例如下：

A: a b **_c_** d e **_f_** 

B: a b **_f_** d e **_c_**

因此需要记录 A 和 B 不同的个数，以及对应的索引，比较不同的个数是否为 2，以及字母是否交叉相等。


``` java
class Solution {
    public boolean buddyStrings(String A, String B) {
        if(A.length() != B.length()) {
            return false;
        }
        char[] lettersA = A.toCharArray(), lettersB = B.toCharArray();
        int num = 0;
        int first = 0, second = 0;
        if(A.equals(B)) {
            int[] freq = new int[26]; 
            for(int i=0;i<lettersA.length;i++) {
                freq[lettersA[i] -'a']++;
                if(freq[lettersA[i] -'a'] >= 2) {
                    return true;
                }
            }
        } else {
            for(int i=0;i<lettersA.length;i++) {
                if(lettersA[i] != lettersB[i]) {
                    num++;
                    if(num ==1) {
                        first = i;
                    } else if(num == 2) {
                        second = i;
                    }
                    if(num > 2) {
                        return false;
                    }
                }
            }
        }

        return num == 2 && 
            lettersA[first] == lettersB[second]&&
            lettersA[second] == lettersB[first];
    }
}
```

[title]: https://leetcode.com/problems/buddy-strings
