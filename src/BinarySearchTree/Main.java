package BinarySearchTree;

import com.sun.security.jgss.GSSUtil;

public class Main {

    public static void main(String [] args){

        BinarySearchTree myTree=new BinarySearchTree();

     /*   myTree.insert(1);
        myTree.insert(2);
        myTree.insert(3);

        System.out.println(myTree.root.right.right.value);
    */


        myTree.rInsert(2);
        myTree.rInsert(1);
        myTree.rInsert(3);

        System.out.println("Root "+ myTree.root.value);
        System.out.println("Left "+ myTree.root.left.value);
        System.out.println("Right "+ myTree.root.right.value);


    }
}
