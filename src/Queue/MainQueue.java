package Queue;

public class MainQueue {

    public static void main(String[] args){

        Queue myQueue = new Queue(10);

        myQueue.getLast();
        myQueue.getFirst();
        myQueue.printQueue();


        myQueue.enqueue(3);
        myQueue.enqueue(4);
        myQueue.printQueue();

        System.out.println("After dequeue : ");

        myQueue.dequeue();
        myQueue.printQueue();


    }
}
