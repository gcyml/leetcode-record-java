tion for singly-linked list.
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
