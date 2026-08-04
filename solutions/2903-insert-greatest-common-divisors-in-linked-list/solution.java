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
    public ListNode gcd(ListNode a, ListNode b) {
        int x = a.val;
        int y = b.val;

        while (y != 0) {
            int temp = y;
            y = x % y;
            x = temp;
        }

        return new ListNode(x);
    }

    public ListNode insertGreatestCommonDivisors(ListNode head) {
        // algo
        // make another ll 
        // new Head of new ll will be same as head iterate through the ll , curr = head and next will be curr.next , 
        // new Head will be curr and next node will be gcd of curr and next then curr will be next 
        ListNode curr = head;
        ListNode nextNode = curr.next;
        ListNode newNode = new ListNode(curr.val);
        ListNode currNewNode = newNode;

        while(curr.next!=null) {
            currNewNode.next = gcd(curr,nextNode);
            currNewNode = currNewNode.next;
            currNewNode.next = nextNode;
            currNewNode = currNewNode.next;
            curr = nextNode;
            // if(nextNode.next!=null) {
            // }
                nextNode = nextNode.next;
        }
        return newNode;

    }
}
