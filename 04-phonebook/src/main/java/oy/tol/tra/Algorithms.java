package oy.tol.tra;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;
import java.util.function.Predicate;

public class Algorithms {

    public static <T> void sortWithComparator(T[] array, Comparator<? super T> comparator) {
        Arrays.sort(array, comparator);
    }

    public static <T> int partitionByRule(T[] array, int count, Predicate<T> rule) {
        // Find first element rules applies to.
        // Index of that element will be in variable index.
        int index = 0;
        for (; index < count; index++) {
            if (rule.test(array[index])) {
                break;
            }
        }
        // If went to the end, nothing was selected so quit here.
        if (index >= count) {
            return count;
        }
        // Then start finding not selected elements starting from next from index.
        // If the element is not selected, swap it with the selected one.
        int nextIndex = index + 1;
        // Until end of array reached.
        while (nextIndex != count) {
            if (!rule.test(array[nextIndex])) {
                T temp = array[index];
                array[index] = array[nextIndex];
                array[nextIndex] = temp;
                // If swapping was done, add to index since now it has non-selected element.
                index++;
            }
            nextIndex++;
        }
        return index;
    }

    public static <E extends Comparable<E>> void fastSort(E[] array) {
        quickSort(array, 0, array.length - 1);
    }

    public static <E extends Comparable<E>> void quickSort(E[] array, int begin, int end) {
        Stack<Integer> stack = new Stack<>();
        stack.push(begin);
        stack.push(end);

        while (!stack.isEmpty()) {
            end = stack.pop();
            begin = stack.pop();

            if (begin < end) {
                int partitionIndex = partition(array, begin, end);

                if (partitionIndex - 1 > begin) {
                    stack.push(begin);
                    stack.push(partitionIndex - 1);
                }

                if (partitionIndex + 1 < end) {
                    stack.push(partitionIndex + 1);
                    stack.push(end);
                }
            }
        }
    }

    private static <E extends Comparable<E>> int partition(E[] array, int begin, int end) {
        E pivot = array[end];
        int i = begin - 1;
        for (int j = begin; j < end; j++) {
            if (array[j].compareTo(pivot) < 0) {
                i++;
                swap(array, i, j);
            }
        }
        swap(array, i + 1, end);
        return i + 1;
    }

    public static <T extends Comparable<T>> void swap(T[] nums, int i, int j) {
        T temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}