# [Groups of Special-Equivalent Strings][title]

## Description

You are given an array `A` of strings.

Two strings `S` and `T` are  _special-equivalent_  if after any number of
_moves_ , S == T.

A _move_ consists of choosing two indices `i` and `j` with `i % 2 == j % 2`,
and swapping `S[i]` with `S[j]`.

Now, a _group of special-equivalent strings from`A`_  is a non-empty subset S
of `A` such that any string not in S is not special-equivalent with any string
in S.

Return the number of groups of special-equivalent strings from `A`.

**Example 1:**

```
Input: ["a","b","c","a","c","c"]
Output: 3
Explanation: 3 groups ["a","a"], ["b"], ["c","c","c"]
```

**Example 2:**

```
Input: ["aa","bb","ab","ba"]
Output: 4
Explanation: 4 groups ["aa"], ["bb"], ["ab"], ["ba"]
```

**Example 3:**

```
Input: ["abc","acb","bac","bca","cab","cba"]
Output: 3
Explanation: 3 groups ["abc","cba"], ["acb","bca"], ["bac","cab"]
```

**Example 4:**

```
Input: ["abcd","cdab","adcb","cbad"]
Output: 1
Explanation: 1 group ["abcd","cdab","adcb","cbad"]
```

**Note:**

* `1 <= A.length <= 1000`
* `1 <= A[i].length <= 20`
* All `A[i]` have the same length.
* All `A[i]` consist of only lowercase letters.

**Tags:** String

**Difficulty:** Easy

## 思路

strHash函数,传一个字符串,返回该字符串的奇数位字符和偶数位字符出现的在字母表中的分布
构造一个set来存储每个字符串的strHash后的结果

``` java
class Solution {
    public int numSpecialEquivGroups(String[] A) {
       Set<String> strSet = new HashSet<>();
        for (String tmp : A) {
            strSet.add(strHash(tmp));
        }
        return strSet.size();
    }

    private String strHash(String tmp) {
        if (tmp.length() == 1) return tmp;
        int[] cArr = new int[52];
        int odd = 0;
        for (char c : tmp.toCharArray()) {
            cArr[(odd++ % 2 == 0 ? 26 : 0) + c - 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for (int i : cArr) {
            sb.append(i);
        }
        return sb.toString();
    }
}
```

[title]: https://leetcode.com/problems/groups-of-special-equivalent-strings
