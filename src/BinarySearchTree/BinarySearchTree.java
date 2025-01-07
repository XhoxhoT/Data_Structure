package BinarySearchTree;

import com.sun.source.tree.BreakTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

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

    private boolean rContains(Node currentNode, int value){

        if(currentNode == null)
            return false;
        if(currentNode.value == value)
            return true;
        if(value < currentNode.value){
            return rContains(currentNode.left, value);
        }else{
            return rContains(currentNode.right, value);
        }

    }

    public boolean rContains(int value){
        return rContains(root, value);
    }

    private Node rInsert(Node currentNode, int value){

        if(currentNode == null){
            return new Node(value);
        }

        if(value<currentNode.value){
            currentNode.left=rInsert(currentNode.left, value);
        }else if (value > currentNode.value){
            currentNode.right=rInsert(currentNode.right,value);
        }

        return currentNode;

    }

    public void rInsert(int value){
        if(root == null)
            root = new Node(value);
        rInsert(root,value);
    }



    private Node deleteNode (Node currentNode, int value){

        if(currentNode==null)
            return null;

        if(value< currentNode.value){
            currentNode.left=deleteNode(currentNode.left,value);
        }else if( value> currentNode.value){
            currentNode.right= deleteNode(currentNode.right,value);
        }else{
            // mas qe kena iteru majtas dhe djathtas ketu mrapa lindin 4 raste,
            // 1. CurrentNode eshte leaf gjethe
            // 2. CurrentNode ka vetem nje bije djathtas
            // 3. CurrentNode ka vetem nje bije majtas
            // 4. CurrentNode ka bije majtas dhe djathtas.

            // rast 1 gjethe
            if(currentNode.left == null && currentNode.right == null){
                return null;
            }
            else if(currentNode.left == null){
                currentNode=currentNode.right;
            }else if (currentNode.right == null){
                currentNode = currentNode.left;
            }else{
                int subTreeMin = minValue(currentNode.right);
                currentNode.value = subTreeMin;
                currentNode.right = deleteNode(currentNode.right,subTreeMin);
            }
        }

        return currentNode;
    }

    public int minValue(Node currentNode){

        while(currentNode.left != null){
            currentNode = currentNode.left;
        }
        return currentNode.value;
    }

    public ArrayList<Integer> BFS(){

        Node currentNode = root;
        Queue<Node> queue = new LinkedList<>();
        ArrayList<Integer> results= new ArrayList<>();

        // Queue e perdorim qe te ruajm currentNode dhe bijat ne nivel n.

        queue.add(currentNode);

        while(queue.size() > 0){
            currentNode = queue.remove();
            results.add(currentNode.value);
            if(currentNode.left != null){
                queue.add(currentNode.left);
            }
            if (currentNode.right != null){
                queue.add(currentNode.right);
            }
        }
        return results;
    }

    public ArrayList<Integer> DFSPreOrder(){

        ArrayList<Integer> results = new ArrayList<>();

        class Traverse{

            Traverse(Node currentNode){

                results.add(currentNode.value);
                if(currentNode.left != null)
                    new Traverse(currentNode.left);
                if(currentNode.right != null)
                    new Traverse(currentNode.right);

            }

        }

        new Traverse(root);
        return results;

    }

    public ArrayList<Integer>DFSPostOrder (){

        ArrayList<Integer>results = new ArrayList<>();

        class Traverse{

            Traverse(Node currentNode){

                if(currentNode.left != null){
                   new Traverse(currentNode.left);
                }
                if(currentNode.right != null){
                    new Traverse(currentNode.right);
                }
                results.add(currentNode.value);
            }
        }

        new Traverse(root);
        return results;

    }


    public ArrayList<Integer>DFSInOrder (){

        ArrayList<Integer>results = new ArrayList<>();

        class Traverse{

            Traverse(Node currentNode){

                if(currentNode.left != null){
                    new Traverse(currentNode.left);
                }
                results.add(currentNode.value);
                if(currentNode.right != null){
                    new Traverse(currentNode.right);
                }

            }
        }

        new Traverse(root);
        return results;

    }





}
