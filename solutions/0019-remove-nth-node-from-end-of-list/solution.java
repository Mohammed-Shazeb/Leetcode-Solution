/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode temp = head;
        int size = 0;
        while (temp != null) {
            temp = temp.next;
            size++;
        }
        if (n == size) {
            return head.next;
        }
        ListNode prev = head;
        int prevNode = size - n;
        int i = 1;
        while (i < prevNode) {
            prev = prev.next;
            i++;
        }
        prev.next = prev.next.next;
        return dummy.next;
    }
}
