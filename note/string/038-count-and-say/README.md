# [Count and Say][title]

## Description

The count-and-say sequence is the sequence of integers with the first five
terms as following:

```
1.     1
2.     11
3.     21
4.     1211
5.     111221
```

`1` is read off as `"one 1"` or `11`.
`11` is read off as `"two 1s"` or `21`.
`21` is read off as `"one 2`, then `one 1"` or `1211`.

Given an integer _n_  where 1 ≤ _n_ ≤ 30, generate the _n_ th term of the
count-and-say sequence.

Note: Each term of the sequence of integers will be represented as a string.



**Example 1:**

```
Input: 1
Output:  "1"
```

**Example 2:**


```
Input: 4
Output:  "1211"
```

**Tags:** String

**Difficulty:** Easy

## 思路

这类层层调用生成的题用递归是最好的，得到上一层的结果后再进行解析。解析时逻辑是碰到连续相同的数字用连续的个数和数值替换，即 `111` 用 `31` 替换。

``` java
class Solution {
    public String countAndSay(int n) {
        StringBuilder sb = new StringBuilder();
        if(n==1) {
            sb.append("1");
        } else {
            String sayStr = countAndSay(n-1);
            char[] character = sayStr.toCharArray();
            for(int i=0;i<character.length;) {
                int j = i;
                while(++j < character.length) {
                    if(character[j] != character[i])
                        break;
                }
                sb.append(String.valueOf(j-i) + character[i]);
                i = j;
            }
        }
        return sb.toString();
    }
}
```

[title]: https://leetcode.com/problems/count-and-say
