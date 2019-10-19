package queue;

public class MyTests {

    public static void main(String[] args) {

        ArrayQueueModule arrayQueueModule = new ArrayQueueModule();
        System.out.println(arrayQueueModule.size());
        System.out.println(arrayQueueModule.isEmpty());
        arrayQueueModule.enqueue("I");
        arrayQueueModule.enqueue("love");
        arrayQueueModule.enqueue("java");
        arrayQueueModule.dequeue();
        System.out.println(arrayQueueModule.element());
        arrayQueueModule.clear();
        System.out.println(arrayQueueModule.size());

        ArrayQueueADT arrayQueueADT = new ArrayQueueADT();
        System.out.println(ArrayQueueADT.size(arrayQueueADT));
        System.out.println(ArrayQueueADT.isEmpty(arrayQueueADT));
        ArrayQueueADT.enqueue(arrayQueueADT, "I");
        ArrayQueueADT.enqueue(arrayQueueADT, "love");
        ArrayQueueADT.enqueue(arrayQueueADT, "java");
        ArrayQueueADT.dequeue(arrayQueueADT);
        System.out.println(ArrayQueueADT.element(arrayQueueADT));
        ArrayQueueADT.clear(arrayQueueADT);
        System.out.println(ArrayQueueADT.size(arrayQueueADT));

        ArrayQueue arrayQueue = new ArrayQueue();
        System.out.println(arrayQueue.size());
        System.out.println(arrayQueue.isEmpty());
        arrayQueue.enqueue("I");
        arrayQueue.enqueue("love");
        arrayQueue.enqueue("java");
        arrayQueue.dequeue();
        System.out.println(arrayQueue.element());
        arrayQueue.clear();
        System.out.println(arrayQueue.size());

    }

}
