package DoublyLinkedListIMP;

public class DoublyLinkedListMain {

    public static void main(String[] args){

        DoublyLinkedList myDll = new DoublyLinkedList(5);

        myDll.getHead();
        myDll.getTail();
        myDll.getLength();


       // myDll.printList();

        myDll.append(3);

        myDll.printList();
    }
}
