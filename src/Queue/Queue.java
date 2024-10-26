package Queue;

public class Queue {

    private Node first;
    private Node last;
    private int length;

    class Node{

        int value;
        Node next;

       public Node(int value){
            this.value=value;
        }
    }

    public Queue(int value) {

        Node newNode = new Node(value);
        this.first = newNode;
        this.last = newNode;
        length++;
    }

    public void getFirst(){
        System.out.println("First: "+first.value);
    }

    public void getLast(){
        System.out.println("Last: "+last.value);
    }

    public void getLength(){
        System.out.println("Length: "+length);
    }

    public void printQueue(){

        Node temp=first;

        while(temp!=null){
            System.out.println(temp.value);
            temp=temp.next;
        }
    }

    public void enqueue(int value){

        Node newNode = new Node(value);

        if(length == 0){
            first=newNode;
            last=newNode;
        }else{
            last.next=newNode;
            last=newNode;
        }
        length++;
    }

    public Node dequeue(){

        if(length == 0)
            return null;

        Node temp=first;
        if(length == 1){
            first = null;
            last = null;
        } else{
            first = first.next;
            // arsyeja pse e bajm kte eshte qe mos te pointojn askund
            // dhe garbage collector ta fshijne nga memoria
            temp.next=null;
        }

        length--;
        return temp;

    }

}
