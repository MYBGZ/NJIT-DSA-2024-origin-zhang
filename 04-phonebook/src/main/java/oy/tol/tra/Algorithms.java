package oy.tol.tra;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Deque;
import java.util.Stack;
import java.util.function.Predicate;

public class Algorithms {

    public static <T> void sortWithComparator(T[] array, Comparator<? super T> comparator) {
        Arrays.sort(array, comparator);
    }

    public static <T> int partitionByRule(T[] array, int count, Predicate<T> rule) {
        int pivotIndex = 0;
        while (pivotIndex < count && rule.test(array[pivotIndex])) {  
            pivotIndex = pivotIndex + 1;  
        }  
        if (pivotIndex >= count) {
            return count;
        }

        int nextIndex = pivotIndex + 1;
        while (nextIndex != count) {
            if (!rule.test(array[nextIndex])) {
                T temp = array[pivotIndex];
                array[pivotIndex] = array[nextIndex];
                array[nextIndex] = temp;
                pivotIndex = pivotIndex + 1;
            }
            nextIndex = nextIndex + 1;
        }
        return pivotIndex;
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

    public static <E extends Comparable<E>> void swap(E[] nums, int i, int j) {
        E temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

