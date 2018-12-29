# [Remove Linked List Elements][title]

## Description

Remove all elements from a linked list of integers that have value **_val_**.

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
    public ListNode removeElements(ListNode head, int val) {
        if(head == null) {
            return head;
        }
 
        ListNode res = head;
        while(head != null) {
            while(head.next != null && head.next.val == val) {
                head.next = head.next.next;
            }
            head = head.next;
        }
        if(res.val == val) {
            res = res.next;
        }
        return res;
    }
}
```

[title]: https://leetcode.com/problems/remove-linked-list-elements