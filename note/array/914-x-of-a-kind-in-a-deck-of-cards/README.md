# [X of a Kind in a Deck of Cards][title]

## Description

In a deck of cards, each card has an integer written on it.

Return `true` if and only if you can choose `X >= 2` such that it is possible
to split the entire deck into 1 or more groups of cards, where:

  * Each group has exactly `X` cards.
  * All the cards in each group have the same integer.


**Example 1:**

```
Input:* [1,2,3,4,4,3,2,1]
Output: true
Explanation : Possible partition [1,1],[2,2],[3,3],[4,4]
```

**Example 2:**

```
Input:* [1,1,1,2,2,2,3,3]
Output: false
Explanation : No possible partition.
```

**Example 3:**

```
Input:* [1]
Output: false
Explanation : No possible partition.
```

**Example 4:**

```
Input:* [1,1]
Output: true
Explanation : Possible partition [1,1]
```

**Example 5:**

```
Input:* [1,1,2,2,2,2]
Output: true
Explanation : Possible partition [1,1],[2,2],[2,2]
```

**Note:**

  1. `1 <= deck.length <= 10000`
  2. `0 <= deck[i] < 10000`


**Tags:** Array, Math

**Difficulty:** Easy

## 思路

题意是把相同数分组，若分组长度均为X的倍数，且X大于2，则为真。解法是记录所有元素的出现次数，由于X必须满足 `2 < X <= min`，若存在X值符合条件，则返回`true`。

``` java
class Solution {
    public boolean hasGroupsSizeX(int[] deck) {
        int[] map = new int[10000];
        int min = Integer.MAX_VALUE;
        for(int i : deck){
            map[i]++;
        }

        for(int i =0;i<10000;i++) {
            if(map[i] > 0) {
                min = Math.min(map[i], min);
            }
        }

        for(int i =2;i<=min;i++){
            int j = 0;
            while(j<10000){
                if(map[j] > 0 && map[j] % i != 0) {
                    break;
                }
                j++;
            }
            if(j == 10000) {
                return true;
            }
        }

        return false;
    }
}
```

[title]: https://leetcode.com/problems/x-of-a-kind-in-a-deck-of-cards
