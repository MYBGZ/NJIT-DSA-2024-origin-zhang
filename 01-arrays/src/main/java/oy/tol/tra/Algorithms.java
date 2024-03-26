package oy.tol.tra;

import java.util.Arrays;

public class Algorithms {

    public static <T extends Comparable<T>> void sort(T [] array) {
        int i = 0;
      while (i < array.length) {
         int j = array.length-1;
         while (j > i) {
            if (array[j].compareTo(array[j-1]) < 0) {
               T tmp = array[j];
               array[j] = array[j-1];
               array[j-1] = tmp;
         }
         j--;
      }
      i++;
   }
    }


    public static <T> void reverse(T [] array) {
        int i = 0;
        while (i < array.length/2) {
         T temp = array[i];
         array[i] = array[array.length-i-1];
         array[array.length-i-1] = temp;
         i++;
     }
    }


    public static int binarySearch(int target, Integer arr[],int begin,int end){
        if(begin <= end){
            int mid = begin + (end-begin) / 2;
            if(arr[mid] == target){
                return mid;
            }else if(arr[mid] < target ){
                return binarySearch(target,arr,mid+1,end);
            }else{
                return binarySearch(target,arr,begin,mid-1);
            }
        }
        return -1;
    }


    public static int binarySearch(String target, String arr[],int begin,int end){
        if(begin <= end){
            int mid = begin + (end - begin) / 2;
            int compareResult = target.compareTo(arr[mid]);
            if(compareResult == 0){
                return mid;
            } else if (compareResult > 0) {
                return binarySearch(target,arr,mid + 1, end);
            }else {
                return binarySearch(target,arr,begin,mid - 1);
            }

        }
        return -1;
    }

    


}
