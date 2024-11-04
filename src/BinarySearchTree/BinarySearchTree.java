package BinarySearchTree;

public class BinarySearchTree {

     Node root;

    class Node{

        int value;
        Node left;
        Node right;

        private Node(int value){
            this.value=value;
        }
    }

    // hapat
    // create newNode
    // if root == null then root = newNode
    // temp = root per iterim ne tree.
    // while loop
    // if newNode == temp return false Binary search tree slejon dy nyje me tnjejten vler

    // if < left perndrshe > (me e madhe) right
    // if null insert newNode lese move to next
    public boolean insert(int value){

        Node newNode = new Node(value);

        if(root == null){
            root = newNode;
            return true;
        }

        Node temp= root;

        while(true){

            if(newNode.value == temp.value)
                return false;
            if(newNode.value < temp.value){
                if(temp.left == null){
                    temp.left=newNode;
                    return true;
                }
                temp=temp.left;
            }else{
                if(temp.right == null){
                    temp.right=newNode;
                    return true;
                }
                temp=temp.right;
            }
        }

    }

    // if root == null return false
    // temp = root
    // whilee temp != null pra deri kur ska me nyje te pemes
    // if < shkojme left
    // else if > shkojm right
    // else == return true,
    // po se gjeti ne while loop return false

    public boolean contains(int value){

        if(root == null) return false;

        Node temp = root;

        while (temp != null){
            if(value < temp.value){
                temp = temp.left;
            }else if (value > temp.value){
                temp=temp.right;
            } else{
                return true;
            }
        }

        return false;
    }


}
