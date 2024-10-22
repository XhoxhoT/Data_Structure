package List;

public class LinkedListBIGO {

//    Ndyshim mes linked list dhe arraylist
//    linkedlist ska indeks, arraylist ka indeks
//    noded ne linkedlist jane te shperndara ne memorie, arraylist jane ne bllok ne memorie

//    Te dyja keto ndyshojn me arrays sepse sjane fixed length.

    private Node head;
    private Node tail;
    private int length;


    class Node {

        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    public LinkedListBIGO(int value) {
        Node newNode = new Node(value);
        head = newNode;
        tail = newNode;
        length = 1;
    }


    public void printList() {

        Node temp = head;
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    public void append(int value) {

        Node newNod = new Node(value);

        if (length == 0) {
            head = newNod;
            tail = newNod;
        } else {

            tail.next = newNod;
            tail = newNod;
        }
        length++;
    }

    public Node removeLast(){

        if(length== 0)
        {
            return null;
        }

        Node temp=head;
        Node pretemp=head;

        while(temp.next != null){
            pretemp=temp;
            temp=temp.next;
        }

        tail=pretemp;
        tail.next=null;

        length--;

        if(length==0){
            head=null;
            tail=null;
        }



        return temp;






    }


    public void prepend(int value){

        Node newNode= new Node(value);

        if(length == 0){
            head=newNode;
            tail=newNode;

        }else {
            newNode.next=head;
            head=newNode;
        }

        length++;



    }


    public Node removeFirst(){

        Node temp;

        if(length==0){
            return null;
        }
        if(length ==1){
            temp=head;
            head=null;
            tail=null;
            length--;
            return temp;
        }

        temp= head.next;
        head=temp;
        // node qe heqim pointerin e bejm null qe garbage collector ta fshije nga memoria

        temp.next=null;
        length--;
        return temp;



    }


    public Node get(int index){

        // kontrollojme indexin a eshte brenda length

        if(index<0 || index >= length)
            return null;
        // krijojme nje node temp qe te iterojme
        Node temp = head;

        for(int i=0; i<index;i++){
            temp=temp.next;
        }
        return temp;

    }


    public boolean set(int index, int value){

        Node temp= get(index);
        if(temp != null){
            temp.value = value;
            return true;
        }
        return false;

    }


    public boolean insert(int index, int value){

        if(index<0 || index >= length)
            return false;

        if(index==0){
            prepend(value);
            return true;
        }
        if (index == length){

            append(value);
            return true;
        }
        Node newNode = new Node(value);
        Node preIndex=get(index-1);
        newNode.next = preIndex.next;
        preIndex.next=newNode;
        length++;
        return true;


    }


    public Node remove(int index){

        // mos harro te updatetosh lengthin
        if(index < 0 || index >length)
            return null;
        if(index == 0)
            return removeFirst();
        if(index == length){
            return removeLast();
        }
        Node temp= get(index);
        Node preTemp=get(index-1);
        preTemp.next=temp.next;
        temp.next=null;
        return temp;

    }


    public void reverse(){

    Node temp = head;
    head=tail;
    tail=temp;

    Node after = temp.next;
    Node before = null;

    for(int i = 0; i<length; i++){
        after=temp.next;
        temp.next=before;
        before=temp;
        temp=after;
    }

    }


    // LeetCode exercises

    public Node findMiddleNode(){

        // Floyd's algorithm
        // 2 pointera njeni leviz dy here me shpejt se tjetri
        // nese kemi rreth, pointeri i shpejt e kap pointerin e ngadalte
        // nese skemi rreth, pointeri i shpejt shkon ne null dhe pointeri i ngadalte duhet te jete ne mes;

        Node fast=head;
        Node slow=head;
        int iteration=0;
        // pervecse duhet te sigurohemi edhe per fast !=null
        // duhet te shofim edhe fast.next sepse teorikisht aty do jemi rradhen tjt

        while(fast!=null && fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            iteration++;
        }

        return slow;

    }


    public boolean hasLoop(){

        Node fast=head;
        Node slow=head;
        int iteration=0;
        // pervecse duhet te sigurohemi edhe per fast !=null
        // duhet te shofim edhe fast.next sepse teorikisht aty do jemi rradhen tjt

        while(fast!=null && fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;

            if(fast==slow){
                return true;
            }
        }

        return false;
    }


// metode qe te gjejme noden e k-te nga fundi

    public Node findKthFromEnd(int k){

        Node fastest=head;
        Node slowestNode=head;

        if(k<0)
            return null;

        // pozicionoi fastest node, K node para slowestNode.
        for(int i=0;i<k;i++){
            // nese fastest eshte null i bjen qe ska k node
            if(fastest == null){
                return null;
            }
            // iterojme deri ne k here
            fastest=fastest.next;
        }

        // perderisa jemi k here para slowest
        // iterojme edhe fastest edhe slowest deri ne momentin qe fastest != null
        // pra kemi arrit ne fund

        while (fastest != null){

            fastest=fastest.next;
            slowestNode=slowestNode.next;
        }
        // kthejm slowestNode
        return slowestNode;

    }


    // Ri orderojm nodet ne list ne baze te nje vlere x
    public void partitionList(int x){

      if(head == null){
          return;
      }

      // ruajme lower and greater headers
      Node dummy1=new Node(0);
      Node dummy2 = new Node(0);

      Node prev1= dummy1;
      Node prev2=dummy2;

      Node current = head;

      while (current != null){

          if(current.value < x){
             // prev1.next -> current ne menyre qe iterimin e rradhes
             // nese plotsohet condition, previous current .next shkon tek current
              prev1.next=current;
              // pra heren tjt do shkojm te current i rradhes
              prev1 = current;
          } else{

              // prev1.next -> current ne menyre qe iterimin e rradhes
              // nese plotsohet condition, previous current .next shkon tek current
              prev2.next=current;
              // pra heren tjt do shkojm te current i rradhes
              prev2 = current;
          }

          current=current.next;

      }

      prev2.next=null;

      prev1.next=dummy2.next;

      head = dummy1.next;

    }




















    // getters and setters


    public Node getTail() {
        return tail;
    }

    public void setTail(Node tail) {
        this.tail = tail;
    }

    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }
}
