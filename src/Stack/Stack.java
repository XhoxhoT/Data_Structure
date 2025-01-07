package Stack;

public class Stack {

    private Node top;
    private int height;

    class Node{

        int value;
        Node next;

        public Node(int value){
            this.value=value;
        }
    }

    public Stack(int value){

        Node newNode = new Node(value);
        top=newNode;
        height=1;
    }

    public void printStack(){

        Node temp=top;

        while(temp != null){
            System.out.println(temp.value);
            temp=temp.next;
        }
    }

    public void getTop(){
        System.out.println("Top : "+top.value);
    }

    public void getHeight(){
        System.out.println("Height : "+this.height);
    }

    // Main logic of stack is Last in First out or First in Last Out
    // Implementimi i stackut me linked list dhe duke perdorur metodat
    // prepend dhe removeFirst kemi kompleksitet me te vogel.
    // O(1), nese do perdornim append dhe Remove last ateher kompleksiteti do ishte
    // O (n), sepse do iteronim tek secila prej nyjeve per te shku ne fund.
    public void push(int value){

        Node newNode=new Node(value);

        if(top==null)
            top=newNode;

        newNode.next=top;
        top=newNode;
        height++;
    }

    public Node pop(){

        if (top==null)
            return null;

        Node temp=top;
        top=top.next;
        temp.next=null;

        height--;
        return temp;

    }

}
