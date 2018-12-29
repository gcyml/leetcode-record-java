# [Lemonade Change][title]

## Description

At a lemonade stand, each lemonade costs `$5`.

Customers are standing in a queue to buy from you, and order one at a time (in
the order specified by `bills`).

Each customer will only buy one lemonade and pay with either a `$5`, `$10`, or
`$20` bill.  You must provide the correct change to each customer, so that the
net transaction is that the customer pays $5.

Note that you don't have any change in hand at first.

Return `true` if and only if you can provide every customer with correct
change.



**Example 1:**
        

**Example 2:**
        

**Example 3:**
        

**Example 4:**
        



**Note:**

  * `0 <= bills.length <= 10000`
  * `bills[i]` will be either `5`, `10`, or `20`.


**Tags:** Greedy

**Difficulty:** Easy

## 思路

``` java
class Solution {
    public boolean lemonadeChange(int[] bills) {
        int hold = 0;
        int fiveCount = 0, tenCount = 0;
        for(int bill : bills) {
            switch(bill) {
                case 5:
                    fiveCount++;
                    break;
                case 10:
                    tenCount++;
                    fiveCount--;
                    break;
                case 20:
                    if(tenCount >= 1) {
                        tenCount--;
                        fiveCount--;
                    }else {
                        fiveCount -=3;
                    }
                    
                    break;
            }
            if(tenCount <0 || fiveCount < 0) {
                return false;
            }
        }
        return true;
    }
}
```

[title]: https://leetcode.com/problems/lemonade-change