package List;

public class MainLinkedList {

    public static void main(String[] args){

        LinkedListBIGO myLinkedLIst=new LinkedListBIGO(4);



        myLinkedLIst.getHead();
        myLinkedLIst.getTail();
        myLinkedLIst.getLength();

//        myLinkedLIst.printList();

        myLinkedLIst.append(3);

        myLinkedLIst.printList();


        System.out.println();
        myLinkedLIst.prepend(5);
        myLinkedLIst.printList();
        System.out.println();
        System.out.println(myLinkedLIst.get(1).value);

//        LinkedListBIGO.Node node = new LinkedListBIGO.Node(10);

    }
}
