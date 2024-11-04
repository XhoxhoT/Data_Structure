package BinarySearchTree;

public class Main {

    public static void main(String [] args){

        BinarySearchTree myTree=new BinarySearchTree();

        myTree.insert(1);
        myTree.insert(2);
        myTree.insert(3);

        System.out.println(myTree.root.right.right.value);
    }
}
