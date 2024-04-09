package oy.tol.tira.books;

import java.util.function.Predicate;

public class Algorithms {
    
    public static <T extends Comparable<T>> void sort(T [] array) {
        for (int i=0;i<array.length-1;i++){
            for (int j=0;j<array.length-1-i;j++){
                if (array[j].compareTo(array[j+1]) > 0) {
                    swap(array,j,j+1);
                }
            }
        }
    }



    public static <E extends Comparable<E>> void fastSort(E [] array) {
        if (array == null || array.length <= 1){
            return;
        }
        quickSort(array,0,array.length-1);
    }


    public static <E extends Comparable<E>> void quickSort(E [] array, int begin, int end){
        if (begin < end){
            int a = partition(array,begin,end);
            quickSort(array,begin,a-1);
            quickSort(array,a+1,end);
        }
    }

    public static <T> void reverse(T [] array) {
        int i = 0;
        while (i < array.length/2) {
            swap(array,i,array.length-i-1);
            i++;
        }
    }

    private static <E extends Comparable<E>> int partition(E [] array, int begin, int end) {
        int a = begin-1;
        for (int leftIndex = begin;leftIndex<end;leftIndex++){
            if (array[leftIndex].compareTo(array[end])<0){
                a++;
                swap(array,a,leftIndex);
            }
        }
        swap(array,a+1,end);
        return a+1;
    }

    
    public static <T> void swap(T[] array,int i,int j){
        T temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }


    public static <T extends Comparable<T>> int binarySearch(T aValue, T [] fromArray, int fromIndex, int toIndex) {
        if (fromIndex > toIndex) {
            return -1;
        }

        int middle = (fromIndex+toIndex)/2;

        if (aValue.compareTo(fromArray[middle]) == 0) {
            return middle;
        }
        else if (aValue.compareTo(fromArray[middle]) < 0) {
            return binarySearch(aValue, fromArray, fromIndex, middle - 1);
        }
        else {
            return binarySearch(aValue, fromArray, middle + 1, toIndex);
        }

    }
    
    public static <T> int partitionByRule(T[] array, int c, Predicate<T> rule) {
        int i = 0;
        while(i < c) {
            if (rule.test(array[i])) {
                break;
            }
            i++;
        }
        if (i >= c) {
            return c;
        }
        int nextIndex = i + 1;
        while (nextIndex != c) {
            if (!rule.test(array[nextIndex])) {
                swap(array, i, nextIndex);
                i++;
            }
            nextIndex++;
        }
        return i;
    }

}