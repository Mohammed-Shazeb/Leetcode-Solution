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
    public ListNode reverseBetween(ListNode head, int left, int right) {

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        ListNode leftPrev = dummy;
        for(int i=1; i<left; i++) {
            leftPrev = leftPrev.next;
        }
        ListNode currLeft = leftPrev.next;

        ListNode currRight = currLeft;
        for(int i=left; i<=right; i++) {
            currRight = currRight.next;
        }

        ListNode newHead = swap(currLeft, currRight);

        leftPrev.next = newHead;
        currLeft.next = currRight;

        return dummy.next;
    }
    
    private ListNode swap(ListNode curr, ListNode end) {
        ListNode prev = null;
        while (curr != end) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
