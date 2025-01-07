package Sorts;

public class selectionSort {

    public static void selectionSort(int[] array){

        for(int i = 0; i < array.length;i++)
        {
            int minIndex = 1;
            for(int j = i+1; j<array.length; j++){
                if(array[j]<array[minIndex])
                    minIndex=j;
            }

            if(i != minIndex){
                int temp = array[i];
                array[i] = array[minIndex];
                array[minIndex] = temp;
            }
        }
    }
}
