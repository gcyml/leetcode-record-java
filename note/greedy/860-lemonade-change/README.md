# [Lemonade Change][title]

## Description

At a lemonade stand, each lemonade costs `$5`.

Customers are standing in a queue to buy from you, and order one at a time (in the order specified by `bills`).

Each customer will only buy one lemonade and pay with either a `$5`, `$10`, or `$20` bill.  You must provide the correct change to each customer, so that the net transaction is that the customer pays $5.

Note that you don't have any change in hand at first.

Return `true` if and only if you can provide every customer with correct change.

**Example 1:**

```   
Input: [5,5,5,10,20]
Output: true
Explanation:
From the first 3 customers, we collect three $5 bills in order.
From the fourth customer, we collect a $10 bill and give back a $5.
From the fifth customer, we give a $10 bill and a $5 bill.
Since all customers got correct change, we output true.
```

**Example 2:**

```
Input: [5,5,10]
Output: true
```

**Example 3:**

```
Input: [10,10]
Output: false
```

**Example 4:**

```
Input: [5,5,10,10,20]
Output: false
Explanation:
From the first two customers in order, we collect two $5 bills.
For the next two customers in order, we collect a $10 bill and give back a $5 bill.
For the last customer, we can't give change of $15 back because we only have two $10 bills.
Since not every customer received correct change, the answer is false.
``` 

**Note:**

* `0 <= bills.length <= 10000`
* `bills[i]` will be either `5`, `10`, or `20`.

**Tags:** Greedy

**Difficulty:** Easy

## 思路

这个题用贪婪算法，每次尽可能的不用 5 元来找零。

这里用了 fiveCount 和 tenCount 来记录手上的五元和十元的数目，每次支付碰到 20 元时，尽可能的用 一张 10 元 和 一张 5 元来找零。 

若手上的零钱不够时，则说明无法正确找零。

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
