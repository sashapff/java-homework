package queue;

public class ArrayQueueADT {
    private int first, size;
    private Object[] elements = new Object[10];

    // a = elements[first..first + size]

    // Pre: element != null
    // Post: first = first' && size = size' + 1 && for all i = 0..size' : a[i]' = a[i] && a[size] = element
    public static void enqueue(ArrayQueueADT queueADT, Object element) {
        assert element != null;
        ensureCapacity(queueADT, queueADT.size + 1);
        queueADT.elements[(queueADT.first + queueADT.size) % queueADT.elements.length] = element;
        queueADT.size++;
    }

    // Pre: element != null
    // Post: first = first' - 1 && size = size' + 1 && for all i = 0..size' : a[i]' = a[i] && a[size] = element
    public static void push(ArrayQueueADT queueADT, Object element) {
        assert element != null;
        ensureCapacity(queueADT, queueADT.size + 1);
        queueADT.first = (queueADT.first - 1 + queueADT.elements.length) % queueADT.elements.length;
        queueADT.elements[queueADT.first] = element;
        queueADT.size++;
    }

    // Pre: a.length >= size
    // Post: a.length > size && for all i = 0..size : a[i]' = a[i]
    private static void ensureCapacity(ArrayQueueADT queueADT, int capacity) {
        if (capacity <= queueADT.elements.length) {
            return;
        }
        Object[] newElements = new Object[2 * capacity];
        for (int i = 0; i < queueADT.size; i++) {
            newElements[i] = queueADT.elements[(i + queueADT.first) % queueADT.elements.length];
        }
        queueADT.first = 0;
        queueADT.elements = newElements;
    }

    // Pre: size > 0
    // Peek: first = first' && size = size' && for all i = 0..size : a[i]' = a[i]
    public static Object element(ArrayQueueADT queueADT) {
        assert queueADT.size > 0;
        return queueADT.elements[queueADT.first];
    }

    // Pre: size > 0
    // Peek: first = first' && size = size' && for all i = 0..size : a[i]' = a[i]
    public static Object peek(ArrayQueueADT queueADT) {
        assert queueADT.size > 0;
        return queueADT.elements[(queueADT.first + queueADT.size - 1) % queueADT.elements.length];
    }

    // Pre: size > 0
    // Peek: first = first' && size = size' - 1 && for all i = 0..size' : a[i]' = a[i]
    public static Object dequeue(ArrayQueueADT queueADT) {
        assert queueADT.size > 0;
        Object now = queueADT.elements[queueADT.first];
        queueADT.first++;
        queueADT.first %= queueADT.elements.length;
        queueADT.size--;
        return now;
    }

    // Pre: size > 0
    // Post: first = first' && size = size' − 1 && for all i = 0..size' : a[i]' = a[i]
    public static Object remove(ArrayQueueADT queueADT) {
        assert queueADT.size > 0;
        Object now = queueADT.elements[(queueADT.first + queueADT.size - 1) % queueADT.elements.length];
        queueADT.size--;
        return now;
    }

    // Post: first = first' && size = size' && for all i = 0..size : a[i]' = a[i]
    public static int size(ArrayQueueADT queueADT) {
        return queueADT.size;
    }

    // Post: first = first' && size = size' && for all i = 0..size : a[i]' = a[i]
    public static boolean isEmpty(ArrayQueueADT queueADT) {
        return queueADT.size == 0;
    }

    // Post: first = first' && size = 0
    public static void clear(ArrayQueueADT queueADT) {
        queueADT.size = 0;
    }

}

