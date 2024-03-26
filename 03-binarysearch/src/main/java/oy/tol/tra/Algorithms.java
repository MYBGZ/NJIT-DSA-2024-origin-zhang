package oy.tol.tra;

import java.util.Arrays;

public class Algorithms {

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



    public static void sort(Integer arr[]){
        int n = arr.length;
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if(arr[j] > arr[j + 1]){
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            if(!swapped){
                break;
            }
        }

    }

    public static void sort(String str[]){
        Arrays.sort(str);
    }


}
