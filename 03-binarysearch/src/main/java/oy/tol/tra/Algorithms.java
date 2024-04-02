package oy.tol.tra;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

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
    
    public static <T extends Comparable<T>> int binarySearch(T aValue, T [] fromArray, int fromIndex, int toIndex) {
        for ( ;fromIndex <= toIndex; ) {
            int a = fromIndex + (toIndex - fromIndex) / 2;
            int b = aValue.compareTo(fromArray[a]);
            if (b == 0) {
                return a;
            }
            else if (b < 0) {
                toIndex = a - 1;
            }
            else {
                fromIndex = a + 1;
            }
        }
        return -1;
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

    public static <E extends Comparable<E>> void fastSort(E[] array) {
        quickSort(array, 0, array.length - 1);
    }

    public static <E extends Comparable<E>> void quickSort(E[] array, int left, int right) {
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(left);
        stack.push(right);

        while (!stack.isEmpty()) {
            right = stack.pop();
            left = stack.pop();

            if (left < right) {
                int partitionIndex = partition(array, left, right);

                if (partitionIndex - 1 > left) {
                    stack.push(left);
                    stack.push(partitionIndex - 1);
                }

                if (partitionIndex + 1 < right) {
                    stack.push(partitionIndex + 1);
                    stack.push(right);
                }
            }
        }
    }

    private static <E extends Comparable<E>> int partition(E[] array, int left, int right) {
        E pivot = array[right];
        int i = left - 1;
        int j = left;
        while (j < right) {
            if(array[j].compareTo(pivot) < 0){
                i = i + 1;
                swap(array, i, j);
            }
            j = j + 1;
        }
        swap(array, i + 1, right);
        return i + 1;
    }

    public static <E extends Comparable<E>> void swap(E[] number, int i, int j) {
        E a = number[i];
        number[i] = number[j];
        number[j] = a;
    }


    

}
