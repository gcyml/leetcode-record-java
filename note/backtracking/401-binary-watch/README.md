# [Binary Watch][title]

## Description

A binary watch has 4 LEDs on the top which represent the **hours** ( **0-11**
), and the 6 LEDs on the bottom represent the **minutes** ( **0-59** ).

Each LED represents a zero or one, with the least significant bit on the
right.

![](https://upload.wikimedia.org/wikipedia/commons/8/8b/Binary_clock_samui_moon.jpg)

For example, the above binary watch reads "3:25".

Given a non-negative integer _n_ which represents the number of LEDs that are
currently on, return all possible times the watch could represent.

**Example:**
            Input: n = 1       Return: ["1:00", "2:00", "4:00", "8:00", "0:01", "0:02", "0:04", "0:08", "0:16", "0:32"]

**Note:**  

  * The order of output does not matter.
  * The hour must not contain a leading zero, for example "01:00" is not valid, it should be "1:00".
  * The minute must be consist of two digits and may contain a leading zero, for example "10:2" is not valid, it should be "10:02".


**Tags:** Backtracking, Bit Manipulation

**Difficulty:** Easy

## 思路

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
