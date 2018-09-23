package by.bsu.likhanova.hybridSorting.sortings;


public class InsertionSorting {
    public static void InsertionSort(int[] array){
        for(int i=1;i<array.length;i++){
            for(int j=i; j>0 && array[j-1]>array[j];j--){
                int tmp=array[j-1];
                array[j-1]=array[j];
                array[j]=tmp;
            }
        }
    }
}
