# [Positions of Large Groups][title]

## Description

In a string `S` of lowercase letters, these letters form consecutive groups of
the same character.

For example, a string like `S = "abbxxxxzyy"` has the groups `"a"`, `"bb"`,
`"xxxx"`, `"z"` and `"yy"`.

Call a group _large_ if it has 3 or more characters.   We would like the
starting and ending positions of every large group.

The final answer should be in lexicographic order.

**Example 1:**

```
Input: "abbxxxxzzy"
Output: [[3,6]]
Explanation : "xxxx" is the single large group with starting  3 and ending positions 6.
```

**Example 2:**

```
Input: "abc"
Output: []
Explanation : We have "a","b" and "c" but no large group.
```

**Example 3:**

```
Input: "abcdddeeeeaabbbcd"
Output: [[3,5],[6,9],[12,14]]
```

**Note:** `1 <= S.length <= 1000`


**Tags:** Array

**Difficulty:** Easy

## 思路

题意是找出字符串中连续字符长度大于等于3的分组。线性遍历，找出符合条件的分组记录位置即可。

``` java
class Solution {
    public List<List<Integer>> largeGroupPositions(String S) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        int start = 0;
        for(int i = 1;i<=S.length();i++) {
            if(i == S.length() || S.charAt(start) != S.charAt(i)) {
                if(i - start > 2) {
                    ArrayList<Integer> l = new ArrayList<>();
                    l.add(start);
                    l.add(i-1);
                    list.add(l);
                }
                start = i;
            }
        }
        return list;
    }
}
```



[title]: https://leetcode.com/problems/positions-of-large-groups
