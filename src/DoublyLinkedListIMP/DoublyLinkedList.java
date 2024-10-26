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

    public void swapFirstLast(){

        if(head == null)
            return;
        if(length <2)
            return;

        int temp = head.value;
        head.value=tail.value;
        tail.value=temp;


    }

    public void reverse(){

        if(head == null)
            return;

        Node currentNode=head;
        Node temp=null;

        while(currentNode != null){

            // 1 ky hap perdoret per heren e 2 dhe ne vazhdim.
            temp=currentNode.prev;
            // 2  prev i current node pointon te nexti
            currentNode.prev=currentNode.next;
            // 3 next-i pointon tek vlera e maperparshme e currentNode-it
            currentNode.next=temp;
            // 4 meqe previ i currentit eshte bere nexti i tij
            // nga hapi 2 i bjen qe currentNode shkon ne next-in fillestar
            currentNode=currentNode.prev;
        }

        temp=head;
        head=tail;
        tail=temp;
    }

    public boolean isPalindrome(){

        Node begin=head;
        Node last=tail;

        if(head==null)
            return true;

        int i = 0;

        while (i<length/2){
            if(begin.value == last.value){
                begin=begin.next;
                last=last.prev;
            }else {
                return false;
            }

            i++;
        }
        return true;

    }

    // kjo per valuet
    public void swapPairsValues(){

        if(length==0 || length ==1){
            return;
        }
        Node temp = head;
        Node fast=temp.next;
        int vl=0;
        while(fast.next!= null){

            vl= fast.value;
            fast.value=temp.value;
            temp.value=vl;
            fast= fast.next.next;
            temp=temp.next.next;
        }

        return;

    }

    // kjo per referencat

    public void swapPairs() {
        Node dummyNode = new Node(0);
        dummyNode.next = head;
        Node previousNode = dummyNode;

        while (head != null && head.next != null) {
            Node firstNode = head;
            Node secondNode = head.next;

            previousNode.next = secondNode;
            firstNode.next = secondNode.next;
            secondNode.next = firstNode;

            secondNode.prev = previousNode;
            firstNode.prev = secondNode;

            if (firstNode.next != null) {
                firstNode.next.prev = firstNode;
            }

            head = firstNode.next;
            previousNode = firstNode;
        }

        head = dummyNode.next;
        if (head != null) head.prev = null;
    }

}
