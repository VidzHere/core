package ds.twoPtr;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

public class RemoveDuplicates {

    public static void main(String[] args) {
        Integer[] numsArray = new Integer[]{3, 2, 1, 4, 5, 7, 6, 90, 2, 3, 3, 2};
        Object[] numsDistinctArray = removeDuplicates(numsArray);
        Stream.of(numsDistinctArray).forEach(System.out::println);
    }

    //Stream distinct
    static Object[] removeDuplicates(Integer[] numsArray) {
        return Stream.of(numsArray).distinct().toArray();
    }

    //Pass array to set
    static int[] removeDuplicatesUsingSets(int[] nums) {
        Set<Integer> uniqueSet = new HashSet<>();
        for (int num : nums) {
            uniqueSet.add(num);
        }
        // Convert the set back to an array
        int[] result = new int[uniqueSet.size()];
        int index = 0;
        for (int num : uniqueSet) {
            result[index++] = num;
        }
        return result;
    }

    static int removeDuplicatesFromSortedArray(int[] a, int n) {
        if (n == 0 || n == 1) return n;
        int j = 0;
        for (int i = 0; i < n - 1; i++) {
            if (a[i] != a[i + 1]) {
                a[j++] = a[i];
            }
        }
        a[j++] = a[n - 1];
        return j;
    }
}
