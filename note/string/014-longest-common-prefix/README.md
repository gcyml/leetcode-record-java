# [Longest Common Prefix][title]

## Description

Write a function to find the longest common prefix string amongst an array of
strings.

If there is no common prefix, return an empty string `""`.

**Example 1:**

```
Input: ["flower","flow","flight"]
Output:  "fl"
```

**Example 2:**

```
Input: ["dog","racecar","car"]
Output:  ""
Explanation: There is no common prefix among the input strings.
```

**Note:**

All given inputs are in lowercase letters `a-z`.

**Tags:** String

**Difficulty:** Easy

## 思路

题意是找出字符串数组的最长公共前缀。解法是先把第一个字符串假设为最长公共前缀 `pre` ，而后遍历数组，若不符合条件，则把 `pre` 尾字母去掉，直到符合条件。最后得出的结果即是最长公共前缀。

``` java
class Solution {
    public String longestCommonPrefix(String[] strs) {

        if (strs == null || strs.length == 0) return "";

        String pre = strs[0];

        for (int i = 1; i < strs.length; i++)
            while(strs[i].indexOf(pre) != 0)
                pre = pre.substring(0, pre.length()-1);
        return pre;
    }
}
```

[title]: https://leetcode.com/problems/longest-common-prefix
