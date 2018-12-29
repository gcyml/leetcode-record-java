# [Remove Duplicates from Sorted List][title]

## Description

Given a sorted linked list, delete all duplicates such that each element
appear only _once_.

**Example 1:**
        

**Example 2:**
        


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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode curNode = head;
        while(curNode != null) {
            ListNode nextNode = curNode.next;
            while(nextNode != null && nextNode.val == curNode.val){
                nextNode = nextNode.next;
            }
            curNode.next = nextNode;
            
            curNode = nextNode;
        }
        return head;
    }
}
```

[title]: https://leetcode.com/problems/remove-duplicates-from-sorted-list