# [To Lower Case][title]

## Description

Implement function ToLowerCase() that has a string parameter str, and returns
the same string in lowercase.



**Example 1:**


```
Input: "Hello"
Output: "hello"
```

**Example 2:**


```
Input: "here"
Output: "here"
```

**Example 3:**


```
Input: "LOVELY"
Output: "lovely"
```


**Tags:** String

**Difficulty:** Easy

## 思路

线性遍历字符，若为大写字母，转换即可。

``` java
class Solution {
    public String toLowerCase(String str) {
        char[] chars = str.toCharArray();
        for(int i=0;i<chars.length;i++) {
            if(chars[i] - 'A' >= 0 && 'Z' - chars[i] >= 0 ) {
                chars[i] += 'a' - 'A'; 
            }
        }
        return  String.valueOf(chars);
    }
}
```

[title]: https://leetcode.com/problems/to-lower-case
