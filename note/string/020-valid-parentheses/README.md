# [Valid Parentheses][title]

## Description

Given a string containing just the characters `'('`, `')'`, `'{'`, `'}'`,
`'['` and `']'`, determine if the input string is valid.

An input string is valid if:

  1. Open brackets must be closed by the same type of brackets.
  2. Open brackets must be closed in the correct order.

Note that an empty string is also considered valid.

**Example 1:**


```
Input:  "()"
Output: true
```

**Example 2:**


```
Input:  "()[]{}"
Output: true
```

**Example 3:**


```
Input:  "(]"
Output: false
```

**Example 4:**


```
Input:  "([)]"
Output: false
```

**Example 5:**


```
Input:  "{[]}"
Output: true
```


**Tags:** String, Stack

**Difficulty:** Easy

## 思路

题意是判断字符串是否为有效的括号。括号的特性和堆先进后出的概念一样，子括号先闭合，才到母括号。

``` java
class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();  
        for(int i = 0; i < s.length(); i++){  
            char candidate = s.charAt(i);  
            if(candidate == '{' || candidate == '[' || candidate == '('){  
                stack.push(candidate);  
            }else{  
                if(stack.isEmpty()){  
                    return false;  
                }  

                if((candidate == '}' && stack.peek() == '{') ||  
                (candidate==']' && stack.peek() == '[') ||  
                (candidate==')' && stack.peek() == '(')){  
                    stack.pop();  
                }else{  
                    return false;  
                }  
            }  
        }  
        return stack.isEmpty();
    }
}
```

[title]: https://leetcode.com/problems/valid-parentheses
