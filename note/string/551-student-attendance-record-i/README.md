# [Student Attendance Record I][title]

## Description

You are given a string representing an attendance record for a student. The
record only contains the following three characters:

1. **'A'** : Absent.
2. **'L'** : Late.
3. **'P'** : Present.

A student could be rewarded if his attendance record doesn't contain **more
than one 'A' (absent)** or **more than two continuous 'L' (late)**.

You need to return whether the student could be rewarded according to his
attendance record.

**Example 1:**

```
Input: "PPALLP"
Output: True
```

**Example 2:**

```
Input: "PPALLL"
Output: False
```

**Tags:** String

**Difficulty:** Easy

## 思路

题意是判断学生是否缺席不超过一次，以及没有连续两次以上的迟到，若满足，则返回 `true`。因此需要两个值记录相关值，用 `lateCount` 记录连续迟到的次数，`absentCount` 记录缺席次数。线性遍历字符串字符，若字符为 `L`，则 `lateCount` 自增，否则重置为 0。若字符为 `A`，则 `absentCount` 自增。两个值每次自增后都要判断是否超过了对应阈值，超过则返回 `false`。

``` java
class Solution {
    public boolean checkRecord(String s) {
        int absentCount = 0, lateCount = 0;
        for(int i =0;i<s.length();i++) {
            if(s.charAt(i) == 'L') {
                if(++lateCount > 2) {
                    return false;
                }
            } else {
                if(s.charAt(i) == 'A') {
                    if(++absentCount > 1) {
                        return false;
                    }
                }
                lateCount = 0;
            }
        }
        return true;
    }
}
```

[title]: https://leetcode.com/problems/student-attendance-record-i
