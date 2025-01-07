package Heaps;

import java.util.*;

public class Heap {

    private List<Integer> heap;

    public Heap(){
        this.heap = new ArrayList<>();
    }

    public List<Integer> getHeap(){
        return new ArrayList<>(heap);
    }

    // index fillojne nga 0
    private int leftChild(int index){
        return 2*index +1;
    }

    private int rightChild(int index){
        return 2 * index +2;
    }

    private int parent(int index){
        return (index -1)/2;
    }

    private void swap(int index1, int index2){
        int temp = heap.get(index1);
        heap.set(index1, heap.get(index2));
        heap.set(index2,temp);
    }

    public void insert(int value){

        // si fillim e shtoj ne fund te arraylistes
        heap.add(value);
        int current = heap.size() - 1;
        // marr indexin e fundit te listes qe perkon me elementin e fundit qe sapo shtova
        // Ne maxHeap
        // per aq kohe sa :
        //  1. Current eshte pozitiv
        //  2. vlera e arrayt ne kete index eshte me e madhe sesa vlera e parentit te tij
        // bejme swap currentin me parentin e tij, gjithashtu updateojm currentin qe u ba sa parenti i tij.
        while(current > 0 && heap.get(current) > heap.get(parent(current))){
            swap(current,parent(current));
            current=parent(current);
        }

    }
    public static int findKthSmallest(int[] nums, int k) {
        Heap maxHeap = new Heap();

        for (int num : nums) {
            maxHeap.insert(num);
            if (maxHeap.getHeap().size() > k) {
                maxHeap.remove();
            }
        }

        return maxHeap.remove();
    }

    public Integer remove(){

        if(heap.size() == 0){
            return null;
        }

        if(heap.size() == 1){
            return heap.remove(0);
        }
        // heqim root-in pra max value dhe ne vend te saj vendosim vleren e fundit te arraylistes
        // ne menyre qe me pas ta krahasojme newRoote-in me bijat dhe ta vendosim ku duhet.
        int maxValue = heap.get(0);
        heap.set(0, heap.remove(heap.size() -1));
        sinkDown(0);
        return maxValue;
    }

    private void sinkDown(int index){

        int maxIndex=index;

        // gjithmone mbajme mend qe pema duhet te jete komplete pra fillon nga e majta ne te djathte

        while(true){

            int leftIndex=leftChild(index);
            int rightIndex= rightChild(index);

            if( leftIndex < heap.size() && heap.get(leftIndex) > heap.get(maxIndex)){
                maxIndex = leftIndex;
            }
            if( rightIndex < heap.size() && heap.get(rightIndex) > heap.get(maxIndex)){
                maxIndex = rightIndex;
            }

            if(maxIndex != index){
                swap(index,maxIndex);
                index = maxIndex;
            }else {
                return;
            }

        }
}



}
