package queue;

public class ArrayQueueModule {
    private static int first, size;
    private static Object[] elements = new Object[10];

    // a = elements[first..first + size]

    // Pre: element != null
    // Post: first = first' && size = size' + 1 && for all i = 0..size' : a[i]' = a[i] && a[size] = element
    public static void enqueue(Object element) {
        assert element != null;
        ensureCapacity(size + 1);
        elements[(first + size) % elements.length] = element;
        size++;
    }

    // Pre: element != null
    // Post: first = first' - 1 && size = size' + 1 && for all i = 0..size' : a[i + 1]' = a[i] && a[0] = element
    public static void push(Object element) {
        assert element != null;
        ensureCapacity(size + 1);
        first = (first - 1 + elements.length) % elements.length;
        elements[first] = element;
        size++;
    }

    // Pre: a.length >= size
    // Post: a.length > size && for all i = 0..size : a[i]' = a[i]
    private static void ensureCapacity(int capacity) {
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

    // Pre: size > 0
    // Peek: first = first' && size = size' && for all i = 0..size : a[i]' = a[i]
    public static Object element() {
        assert size > 0;
        return elements[first];
    }

    // Pre: size > 0
    // Peek: first = first' && size = size' && for all i = 0..size : a[i]' = a[i]
    public static Object peek() {
        assert size > 0;
        return elements[(first + size - 1) % elements.length];
    }

    // Pre: size > 0
    // Peek: first = first' && size = size' - 1 && for all i = 0..size' : a[i]' = a[i]
    public static Object dequeue() {
        assert size > 0;
        Object now = elements[first];
        first++;
        first %= elements.length;
        size--;
        return now;
    }

    // Pre: size > 0
    // Post: first = first' && size = size' − 1 && for all i = 0..size' : a[i]' = a[i]
    public static Object remove() {
        assert size > 0;
        Object now = elements[(first + size - 1) % elements.length];
        size = (size - 1 + elements.length) % elements.length;
        return now;
    }

    // Post: first = first' && size = size' && for all i = 0..size : a[i]' = a[i]
    public static int size() {
        return size;
    }

    // Post: first = first' && size = size' && for all i = 0..size : a[i]' = a[i]
    public static boolean isEmpty() {
        return size == 0;
    }

    // Post: first = first' && size = 0
    public static void clear() {
        size = 0;
    }

}

