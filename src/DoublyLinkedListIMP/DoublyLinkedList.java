package DoublyLinkedListIMP;

public class DoublyLinkedList {

    class Node{
        int value;
        Node prev;
        Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    private Node head;
    private Node tail;
    private int length;

    public DoublyLinkedList(int value){

        Node newNode = new Node(value);
        head=newNode;
        tail=newNode;
        length=1;
    }

    public void getHead() {
        System.out.println("Head : "+head.value);
    }

    public void getTail() {
        System.out.println("Tail : "+ tail.value);
    }

    public void setTail(Node tail) {
        this.tail = tail;
    }

    public void getLength() {
        System.out.println("Length: "+length);
    }

    public void setLength(int length) {
        this.length = length;
    }

    public void printList(){
        Node temp=head;

        while(temp!=null)
        {
            System.out.println(temp.value);
            temp=temp.next;
        }
    }


    public void append(int value){

        // 3 raste :
            // 0 ,1 , 1<
        Node newNode = new Node(value);

        // linkedlist me 0 item in it.
        if(head == null){
            head=newNode;
            tail=newNode;
        }else{
            tail.next = newNode;
            newNode.prev=tail;
            tail=newNode;
        }

        length++;

    }


    public void prepend(int value){

        Node newNode = new Node(value);

        if(head==null){
            head=newNode;
            tail=newNode;
        }else{
            newNode.next=head;
            head.prev=newNode;
            head=newNode;
        }
        length++;
    }

    public Node removeLast(){

        Node temp=tail;

        if(length == 0)
            return null;
        if(length==1){
            head=null;
            tail=null;
            length--;
            return temp;
        }else {
            tail=tail.prev;
            tail.next=null;
            temp.prev=null;
            length--;
            return temp;

        }

    }

    public Node removeFirst(){

        if(head == null){
            return null;
        }
        Node temp=head;
        if(length==1){
            head=null;
            tail=null;
            length--;
            return temp;
        }
        head=head.next;
        head.prev=null;
        temp.next=null;
        return temp;
    }

}
