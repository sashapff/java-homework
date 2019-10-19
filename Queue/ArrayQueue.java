package queue;

public class ArrayQueue extends AbstractQueue {
    private int first;
    private Object[] elements = new Object[10];

    protected void doEnqueue(Object element) {
        ensureCapacity(size + 1);
        elements[(first + size) % elements.length] = element;
    }

    private void ensureCapacity(int capacity) {
        if (capacity <= elements.length) {
            return;
        }
        Object[] newElements = new Object[2 * capacity];
        for (int i = 0; i < size; i++) {
            newElements[i] = elements[(i + first) % elements.length];
        }
        first = 0;
        elements = newElements;
    }

    protected Object doElement() {
        return elements[first];
    }

    protected Object doDequeue() {
        Object ans = elements[first];
        first++;
        first %= elements.length;
        return ans;
    }

    protected void doClear() {
        first = 0;
    }

    protected ArrayQueue doCopy() {
        ArrayQueue ans = new ArrayQueue();
        for (int i = first; i < first + size; i++) {
            ans.enqueue(elements[i % elements.length]);
        }
        return ans;
    }
}

