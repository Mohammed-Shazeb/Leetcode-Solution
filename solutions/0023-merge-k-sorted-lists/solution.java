import java.util.*;

class Solution {
    // Converts an array to linked list
    public ListNode arrayToLinkedList(int[] arr) {
        if (arr == null || arr.length == 0)
            return null;

        ListNode head = new ListNode(arr[0]);
        ListNode current = head;

        for (int i = 1; i < arr.length; i++) {
            current.next = new ListNode(arr[i]);
            current = current.next;
        }

        return head;
    }

    // Merges k sorted linked lists into one sorted list
    public ListNode mergeKLists(ListNode[] lists) {
        List<Integer> values = new ArrayList<>();

        // Collect all values from the lists
        for (int i = 0; i < lists.length; i++) {
            ListNode temp = lists[i];
            while (temp != null) {
                values.add(temp.val);
                temp = temp.next;
            }
        }

        // Sort the values
        Collections.sort(values);

        // Convert back to linked list
        int[] arr = values.stream().mapToInt(i -> i).toArray();
        return arrayToLinkedList(arr);
    }
}

