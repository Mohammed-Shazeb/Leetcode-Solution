import java.util.*;

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        Queue<ListNode> q = new LinkedList();
        for(ListNode list: lists){
            q.add(list);
        }
        while(q.size() > 1){
            ListNode l1 = q.poll();
            ListNode l2 = q.poll();
            q.add(mergeTwoList(l1, l2));
        }
        return q.peek();
    }

    public ListNode mergeTwoList(ListNode l1, ListNode l2){
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        ListNode dummy = new ListNode(-1);
        ListNode head1 = l1;
        ListNode head2 = l2;
        ListNode curr = dummy;

        while(head1 != null && head2 != null) {
            if(head1.val <= head2.val) {
                curr.next = head1;
                head1 = head1.next;
            }
            else {
                curr.next = head2;
                head2= head2.next;
            }
            curr = curr.next;
        }
        if(head1 == null) {
            curr.next = head2;
        }
        else {
            curr.next = head1;
        }
        return dummy.next;
    }
}


