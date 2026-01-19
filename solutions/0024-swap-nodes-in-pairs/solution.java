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
    public ListNode swapPairs(ListNode head) {
        // Base case: if 0 or 1 node, nothing to swap
        if (head == null || head.next == null) return head;

        // Nodes to be swapped
        ListNode first = head;
        ListNode second = head.next;

        // Recursively swap the rest of the list
        first.next = swapPairs(second.next);
        second.next = first;

        // Second node becomes the new head after swap
        return second;
    }
}

