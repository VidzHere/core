package ds.twoPtr;

import java.util.HashMap;
import java.util.Map;

public class PairSumProblem {

    /*
    If we want ti find 2 indices which sum uup to a tarhet & the array is sorted,we can start from left
    and  right with the 2 popinters, and move themm according to the sum at everytime.
    Eventually we will find the  target from those 2 indices, or just return -1 iif we don't.
    However , the logic would be more  complex if array is not sorted. We can simply store  the elements
    in the a hashmap as we go, and eventually return when we find target- nums[i] in the array as we're going
    forward.
    * */

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        System.out.println("Pairs with sum " + target + ":");
        findPairs(nums, target);
    }

    static boolean pairSumInSortedArray(int[] num, int n, int target) {
        int i = 0;
        int j = n - 1;
        while (i < j) {
            if (num[i] + num[j] == target) {
                return true;
            } else if (num[i] + num[j] < target) {
                i++;
            } else {
                j--;
            }
        }
        return false;
    }

    public static void findPairs(int[] nums, int target) {
        Map<Integer, Integer> numMap = new HashMap<>();
        for (int num : nums) {
            int complement = target - num;
            if (numMap.containsKey(complement)) {
                System.out.println("Pair found: (" + numMap.get(complement) + ", " + num + ")");
            }
            numMap.put(num, complement);
        }
    }
}
