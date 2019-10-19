package queue;

import java.util.function.Function;
import java.util.function.Predicate;

public interface Queue {
    // a = elements of queue
    // first = first element of queue

    // Pre: element != null
    // Post: first = first' && size = size' + 1 && for all i = 0..size' : a[i]' = a[i] && a[size] = element
    void enqueue(Object element);

    // Pre: size > 0
    // Peek: first = first' && size = size' && for all i = 0..size : a[i]' = a[i]
    Object element();

    // Pre: size > 0
    // Peek: first = first' && size = size' - 1 && for all i = 0..size : a[i]' = a[i]
    Object dequeue();

    // Post: first = first' && size = size' && for all i = 0..size : a[i]' = a[i]
    int size();

    // Post: first = first' && size = size' && for all i = 0..size : a[i]' = a[i]
    boolean isEmpty();

    // Post: first = 0 && size = 0
    void clear();

    // b = copy of a
    // Post: for all i = 0..size : a[i] = b[i]
    AbstractQueue copy();

    // Post: 0 <= size' <= size && for all i = 0..size' : a[i] is correct by predicate
    AbstractQueue filter(Predicate<Object> predicate);

    // Post: for all i = 0..size : a[i] = function(a[i])
    AbstractQueue map(Function<Object, Object> function);
}
