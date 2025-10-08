/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/
class Solution {
    public Node flatten(Node head) {
        if (head == null) return null;

        Stack<Node> stack = new Stack<>();
        Node current = head;

        while (current != null) {
            if (current.child != null) {
                // If there's a next node, push it to the stack to visit later
                if (current.next != null) {
                    stack.push(current.next);
                }

                // Connect child as the next node
                current.next = current.child;
                current.child.prev = current;
                current.child = null;
            }

            // If at the end of a level and stack isn't empty, pop next level
            if (current.next == null && !stack.isEmpty()) {
                Node next = stack.pop();
                current.next = next;
                next.prev = current;
            }

            current = current.next;
        }

        return head;
    }
}

