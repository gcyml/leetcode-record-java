# [Palindrome Linked List][title]

## Description

Given a singly linked list, determine if it is a palindrome.

**Example 1:**

```
Input: 1- >2
Output: false
```

**Example 2:**

```
Input: 1- >2->2->1
Output: true
```

**Follow up:**  
Could you do it in O(n) time and O(1) space?

**Tags:** Linked List, Two Pointers

**Difficulty:** Easy

## 思路

 判断链表是否为回文链表。
 要判断回文链表，关键在于判断链表的中心点在哪。这里用了双指针法，慢指针走一步，快指针走两步，当快指针走完时，慢指针即在中心位置，用栈存入所有的慢指针指向的节点。
 而后，慢指针只需向前，与栈中弹出的节点进行比较。若全等，即为回文链表。

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
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null) {
            return true;
        }
        Stack<ListNode> st = new Stack<>();
        ListNode fast = head, slow = head;
        st.push(slow);
        while(fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            st.push(slow);
        }
        if (fast.next == null) st.pop();
        while(slow.next != null) {
            slow = slow.next;
            ListNode top = st.pop();
            if(top.val != slow.val) {
                return false;
            }
        }
        return true;
    }
}
```

[title]: https://leetcode.com/problems/palindrome-linked-list
