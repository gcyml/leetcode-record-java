# [Reverse Linked List][title]

## Description

Reverse a singly linked list.

**Example:**
            Input: 1- >2->3->4->5->NULL    Output: 5- >4->3->2->1->NULL    

**Follow up:**

A linked list can be reversed either iteratively or recursively. Could you
implement both?


**Tags:** Linked List

**Difficulty:** Easy

## 思路

``` java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next==null) {
            return head;
        }
        ListNode tmp = reverseList(head.next);
        // tmp.next = head;
        head.next.next = head;
        head.next = null;
        return tmp;
    }
}
```

[title]: https://leetcode.com/problems/reverse-linked-list
