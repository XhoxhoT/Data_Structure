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

    public Node get(int index){

        if(index <0 || index>=length)
            return null;

        Node temp=head;
        int i=0;
        // e bajme ne menyren me eficente, pra dy rruge:
        // ideks afer :
                //      a. tail
                //      b.head
        // ne varesi te ketij info ne vazhdojme traversalin.
        if(index<length/2){
            while(i<index){
                temp=temp.next;
                i++;
            }
        }else{
            temp=tail;
            while(i<length-index-1){
                temp=temp.prev;
                i++;
            }
        }

        return temp;
    }

    public boolean set(int value, int index){

        Node temp=get(index);
        if(temp!= null){
            temp.value=value;
            return true;
        }

        return  false;
    }

    public boolean insert (int index, int value){

        Node newNode = new Node(value);

        if(index<0 || index>length)
            return false;

        if(index==0){
            prepend(value);
            return true;
        }
        if (index == length){

            append(value);
            return true;
        }

        Node pretemp=get(index-1);
        Node temp=get(index);
        newNode.next=pretemp.next;
        pretemp.next=newNode;
        newNode.prev=temp.prev;
        temp.prev=newNode;

        length++;
        return true;

    }

    public Node remove(int index){

        if (index < 0 || index >= length){
            return null;
        }
        if (index == 0){
            return removeFirst();
        }

        if (index == length-1){
            return removeLast();
        }

        Node temp=get(index);
        temp.next.prev=temp.prev;
        temp.prev.next=temp.next;
        temp.next=null;
        temp.prev=null;
        length--;
        return temp;
    }

}
