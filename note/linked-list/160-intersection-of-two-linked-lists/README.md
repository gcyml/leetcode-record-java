# [Intersection of Two Linked Lists][title]

## Description

Write a program to find the node at which the intersection of two singly
linked lists begins.

For example, the following two linked lists:

[![](https://assets.leetcode.com/uploads/2018/12/13/160_statement.png)](https://assets.leetcode.com/uploads/2018/12/13/160_statement.png)

begin to intersect at node c1.



**Example 1:**

[![](https://assets.leetcode.com/uploads/2018/12/13/160_example_1.png)](https://assets.leetcode.com/uploads/2018/12/13/160_example_1.png)
        



**Example 2:**

[![](https://assets.leetcode.com/uploads/2018/12/13/160_example_2.png)](https://assets.leetcode.com/uploads/2018/12/13/160_example_2.png)
        



**Example 3:**

[![](https://assets.leetcode.com/uploads/2018/12/13/160_example_3.png)](https://assets.leetcode.com/uploads/2018/12/13/160_example_3.png)
        



**Notes:**

  * If the two linked lists have no intersection at all, return `null`.
  * The linked lists must retain their original structure after the function returns.
  * You may assume there are no cycles anywhere in the entire linked structure.
  * Your code should preferably run in O(n) time and use only O(1) memory.


**Tags:** Linked List

**Difficulty:** Easy

## 思路

``` java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode currA = headA, currB = headB;
        // A+B = B+A,åæé¿åº¦å·®è¡¥æ
        while (currA != currB) {
            currA = currA == null? headB : currA.next;
            currB = currB == null? headA : currB.next;
        }
        return currA;
    }
}
```

[title]: https://leetcode.com/problems/intersection-of-two-linked-lists