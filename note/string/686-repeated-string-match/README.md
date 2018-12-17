# [Repeated String Match][title]

## Description

Given two strings A and B, find the minimum number of times A has to be
repeated such that B is a substring of it. If no such solution, return -1.

For example, with A = "abcd" and B = "cdabcdab".

Return 3, because by repeating A three times ("abcdabcdabcd"), B is a
substring of it; and B is not a substring of A repeated two times
("abcdabcd").

**Note:**  
The length of `A` and `B` will be between 1 and 10000.


**Tags:** String

**Difficulty:** Easy

## 思路

题意是给定字符串 `A` 和 `B`，求出 `A` 至少需要重复多少次才能使 `B` 成为 `A` 的子字符串。要使得 `B` 成为 `A` 的子字符串，至少 `A` 的长度必须要大于等于 `B`。此时，若符合条件则返回重复的次数。若不符合，则B可能恰好是 `A` 和 `B` 首尾连接而成，因此再重复一次，可保证避免错过这种情况。此时，若仍然找不到，再增加重复次数已是做无用功，返回 -1。

``` java
class Solution {
    public int repeatedStringMatch(String A, String B) {
        int cnt = 1;
        String t = A;
        while(t.length() < B.length()) {
            t += A;
            cnt++;
        }
        if(t.indexOf(B) != -1) {
            return cnt;
        } 
        return (t+A).indexOf(B) != -1? cnt+1: -1;
    
    }
}
```

[title]: https://leetcode.com/problems/repeated-string-match
