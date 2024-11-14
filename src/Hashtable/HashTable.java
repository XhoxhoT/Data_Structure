package Hashtable;

import java.util.ArrayList;

public class HashTable {

    private int size = 7;
    private Node[] dataMap;

    class Node{

        String key;
        int value;
        Node next;

        Node(String key, int value){
            this.key=key;
            this.value=value;
        }
    }

    public HashTable(){

        dataMap = new Node[size];
    }

    public void printTable(){

        for(int i = 0; i<dataMap.length; i++){

            System.out.println(i+ " : ");
            Node temp = dataMap[i];

            while(temp != null){

                System.out.println("    {"+temp.key+"= "+temp.value+"}");
                // ktu sigurohena qe nese ne nje addrese kemi me shume se nje key value
                // ti shkojm deri ne fund dhe ti ekspozojme te gjitha nodet e asaj adrese.
                
                temp=temp.next;
            }
        }

    }

    // pra we treat getting an item, setting an item and hash method as O(1) sepse
    // perderisa metoda hash i jep random adresat ti bjen qe vlerat do jene te shperndame.

    // HashMap/HashTable is one way, pra ti i jep keyn qe ka me ba hashin
    // dhe ajo te jep adresen, dhe jo anasjelltas
    // pra ;
    //          1. One Way
    //          2. Determistic
    // per ate funksion hash, sa here qe ti i jep tnjejten key, ai gjeneron tnjejten adrese.

    // ka raste qe ka edhe collision pra per dy key te ndryshem funksioni hash na jep tnjejten adrese

    // procedohet ne dy menyra:

    // 1. Separate chaining => tek ajo adrese ruajme nje linked list, kjo bahet e mundshme nepermjet Nodes next;
    // 2. adresa ma e afert  => nese adresa asht e xanun ateher shko te nyja ma e afert e lirshme.

    //

    private int hash (String key){

        int hash = 0;
        char [] keyChars = key.toCharArray();
        // kompleksiteti = 0(1), sepse nuk varet sa elemente ke ti mren ne hashtable.

        for(int i=0;i< keyChars.length; i++){

            int asciiValue=keyChars[i];
            hash = (hash + asciiValue*23) % dataMap.length;
        }

        return hash;
    }

    public void set (String key, int value){

        int index = hash(key);
        Node newNode = new Node(key,value);

        if(dataMap[index] == null){
            // nese vendi a bosh e insertojme direkt
            dataMap[index] = newNode;
        }else{
            Node temp = dataMap[index];

            while(temp.next!=null){
                temp=temp.next;
            }
            temp.next=newNode;
        }

    }

    public int get(String key){

        // cdo here qe ne hashojme te njejtin key marrim te njejtin rezultat
        int index= hash(key);

        Node temp= dataMap[index];

        while(temp != null){
            if(temp.key == key)
                return temp.value;
            temp = temp.next;
        }
        return 0;
    }

    public ArrayList keys(){

        ArrayList<String> allKeys = new ArrayList<>();

        for(int i = 0; i<dataMap.length; i++){

            Node temp = dataMap[i];

            while(temp != null){
                allKeys.add(temp.key);
                temp=temp.next;
            }
        }
        return allKeys;
    }




}
