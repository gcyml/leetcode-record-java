# [Merge Two Sorted Lists][title]

## Description

Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.

**Example:**

```
Input: 1->2->4, 1->3->4
Output: 1->1->2->3->4->4
```

**Tags:** Linked List

**Difficulty:** Easy

## 思路

题意是合并两个有序链表。比较两个节点值，若 l1.val 小于等于 l2.val，则把 l1 后面的节点和 l2 做合并后，再接入到 l1 的尾部。否则，做相反操作。

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
