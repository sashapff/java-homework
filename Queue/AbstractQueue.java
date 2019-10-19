package queue;

import java.util.function.Function;
import java.util.function.Predicate;

public abstract class AbstractQueue implements Queue {
    protected int size = 0;

    public final void enqueue(Object element) {
        assert element != null;
        doEnqueue(element);
        size++;
    }

    protected abstract void doEnqueue(Object element);

    public final Object element() {
        assert size > 0;
        return doElement();
    }

    protected abstract Object doElement();

    public final Object dequeue() {
        Object result = element();
        doDequeue();
        size--;
        return result;
    }

    protected abstract Object doDequeue();

    public final int size() {
        return size;
    }

    public final boolean isEmpty() {
        return size == 0;
    }

    public final void clear() {
        size = 0;
        doClear();
    }

    protected abstract void doClear();

    public final AbstractQueue copy() {
        return doCopy();
    }

    protected abstract AbstractQueue doCopy();

    public final AbstractQueue filter(Predicate<Object> predicate) {
        AbstractQueue ans = copy();
        for (int i = 0; i < size; i++) {
            Object cur = ans.dequeue();
            if (predicate.test(cur)) {
                ans.enqueue(cur);
            }
        }
        return ans;
    }

    public final AbstractQueue map(Function<Object, Object> function) {
        AbstractQueue ans = copy();
        for (int i = 0; i < size; i++) {
            ans.enqueue(function.apply(ans.dequeue()));
        }
        return ans;
    }

}
