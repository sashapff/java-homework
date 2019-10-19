package queue;

public class LinkedQueue extends AbstractQueue {

    private class Node {
        public Node(Node next, Object value) {
            this.next = next;
            this.value = value;
        }

        private Node next;
        private Object value;
    }

    private Node head = null, tail = null;

    protected void doEnqueue(Object element) {
        if (size != 0) {
            tail = tail.next = new Node(null, element);
        } else {
            head = tail = new Node(null, element);
        }
    }

    protected Object doElement() {
        return head.value;
    }

    protected Object doDequeue() {
        Object ans = head.value;
        head = head.next;
        return ans;
    }

    protected void doClear() {
        head = null;
        tail = null;
    }

    protected LinkedQueue doCopy() {
        LinkedQueue ans = new LinkedQueue();
        Node first = head;
        while (first != null) {
            ans.enqueue(first.value);
            first = first.next;
        }
        return ans;
    }
}
