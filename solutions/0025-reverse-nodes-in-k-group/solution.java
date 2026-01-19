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
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null) return null;

        ListNode tail = head;
        for(int i=0; i<k; i++) {
            if(tail == null) return head;
            tail = tail.next;
        }

        //swap
        ListNode newHead = swap(head, tail);
        //update pointer
        head.next = reverseKGroup(tail, k);
        return newHead;
    }

    private ListNode swap(ListNode curr, ListNode end) {
        ListNode prev = null;
        while(curr != end) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
