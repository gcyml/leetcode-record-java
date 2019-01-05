# [Letter Case Permutation][title]

## Description

Given a string S, we can transform every letter individually to be lowercase or uppercase to create another string. Return a list of all possible strings we could create.

**Examples:**

```
Input: S =  "a1b2"
Output: [ "a1b2", "a1B2", "A1b2", "A1B2"]

Input: S =  "3z4"
Output: [ "3z4", "3Z4"]

Input: S =  "12345"
Output: [ "12345"]
```

**Note:**

* `S` will be a string with length between `1` and `12`.
* `S` will consist only of letters or digits.

**Tags:** Backtracking, Bit Manipulation

**Difficulty:** Easy

## 思路

依次对每个字节进行处理，遇到数字则跳过，字母则分为两种情况：1.不作处理 2.大小写转换。而后传给子问题。

``` java
class Solution {
    public List<String> letterCasePermutation(String S) {
        List<String> list = new ArrayList<>();
        backtracking(list, S.toCharArray(), "", 0);
        return list;

    }

    private void backtracking(List<String> list, char[] cs, String ans, int pos){
        if(pos == cs.length) {
            list.add(ans);
        } else {
            // 若不为数字，则分两种情况传给下一子问题
            if(cs[pos] < '0' || cs[pos] > '9') {
                char l = cs[pos];
                backtracking(list, cs, ans + l, pos + 1);
                if (l >= 'a' && l <= 'z'){
                   l = (char)(l - 'a' + 'A');
                }
                else if (l >= 'A' && l <= 'Z') {
                  l = (char)(l - 'A' + 'a');  
                }
                backtracking(list, cs, ans + l, pos + 1);
            } else {
                backtracking(list, cs, ans + cs[pos], pos+1);
            }
        }
    }
}
```

[title]: https://leetcode.com/problems/letter-case-permutation
