# [Backspace String Compare][title]

## Description

Given two strings `S` and `T`, return if they are equal when both are typed
into empty text editors. `#` means a backspace character.

**Example 1:**
        

**Example 2:**
        

**Example 3:**
        

**Example 4:**
        

**Note** :

  1. `1 <= S.length <= 200`
  2. `1 <= T.length <= 200`
  3. `S` and `T` only contain lowercase letters and `'#'` characters.

**Follow up:**

  * Can you solve it in `O(N)` time and `O(1)` space?


**Tags:** Two Pointers, Stack

**Difficulty:** Easy

## 思路

``` java
class Solution {
    public boolean backspaceCompare(String S, String T) {
        Stack<Integer> stS = new Stack<>();
        Stack<Integer> stT = new Stack<>();
        for(char c : S.toCharArray()) {
            if(c == '#') {
                if(!stS.isEmpty()) {
                    stS.pop();
                 }
            } else {                             
                stS.push((int)c);
            }
        }
        for(char c : T.toCharArray()) {
             if(c == '#') {
                 if(!stT.isEmpty()) {
                    stT.pop();
                 }
            } else {                             
                stT.push((int)c);
            }
            
        }
        while(!stS.isEmpty() && !stT.isEmpty()) {
            if(stS.pop() != stT.pop()) {
                return false;
            }
        }
        return stS.isEmpty() && stT.isEmpty();
    }
}
```

[title]: https://leetcode.com/problems/backspace-string-compare