# [Binary Watch][title]

## Description

A binary watch has 4 LEDs on the top which represent the **hours** ( **0-11** ), and the 6 LEDs on the bottom represent the **minutes** ( **0-59** ).

Each LED represents a zero or one, with the least significant bit on the right.

![pic](https://upload.wikimedia.org/wikipedia/commons/8/8b/Binary_clock_samui_moon.jpg)

For example, the above binary watch reads "3:25".

Given a non-negative integer _n_ which represents the number of LEDs that are currently on, return all possible times the watch could represent.

**Example:**

```
Input: n = 1
Return: ["1:00", "2:00", "4:00", "8:00", "0:01", "0:02", "0:04", "0:08", "0:16", "0:32"]
```

**Note:**  

* The order of output does not matter.
* The hour must not contain a leading zero, for example "01:00" is not valid, it should be "1:00".
* The minute must be consist of two digits and may contain a leading zero, for example "10:2" is not valid, it should be "10:02".

**Tags:** Backtracking, Bit Manipulation

**Difficulty:** Easy

## 思路i

用一个十个位的二进制数来存储小时和分钟。要找出所有的组合，先模拟出选择的过程，每一位值可以选择 1 或 0，即 LED 亮或者不亮，只要最后亮的总数等于给出的 num，即为一个正确答案。所以用回溯算法尝试不同可能。从低位往高位选择，每次可以选择亮和不亮，最后亮的总数等于 num，则添加到结果列表中。
在这里用 ans 表示目前已经选择后的结果，curPos 表示当前的位数。若本次选择是亮灯，则 ans = ans | (1 << curPos)，num = num - 1。

``` java
class Solution {
    List<String> result = new ArrayList<>();
    public List<String> readBinaryWatch(int num) {
        backtrack(num, 0, 0);
        return result;
    }
    public void backtrack(int num, int ans, int curPos) {
        if(num == 0) {
            int h = ans >> 6;
            int m = ans & 0x3f;
            if(h < 12 && m < 60) {
                result.add(String.format("%d:%02d", h, m));
            }
        }
        else if(curPos < 10) {
            backtrack(num-1, ans | (1 << curPos), curPos +1);
            backtrack(num, ans, curPos+1);
        }
    }
}
```

[title]: https://leetcode.com/problems/binary-watch
