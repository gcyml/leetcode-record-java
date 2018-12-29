# [Merge Two Sorted Lists][title]

## Description

Merge two sorted linked lists and return it as a new list. The new list should
be made by splicing together the nodes of the first two lists.

**Example:**
        


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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null) {
            return l2;
        }
        if(l2 == null) {
            return l1;
        }
        if(l2.val<=l1.val) {
            l2.next = mergeTwoLists(l2.next, l1);
            return l2;
        }else {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        }
    }
}
```

[title]: https://leetcode.com/problems/merge-two-sorted-lists