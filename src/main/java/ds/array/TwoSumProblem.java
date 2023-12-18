package ds.array;

/*
In this example, the twoSum method takes an array of integers (nums) and a target value.
It uses a HashMap (numMap) to store the numbers encountered so far and their indices.
The algorithm iterates through the array, calculates the complement needed for the current number to reach the target, and checks if that complement is already in the map. If found,
it returns the indices of the two numbers; otherwise, it continues to the next iteration.
* */

import java.util.HashMap;
import java.util.Map;

public class TwoSumProblem {

    static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complementNo = target - nums[i];
            if (numMap.containsKey(complementNo)) {
                return new int[]{numMap.get(complementNo), i};
            }
            numMap.put(nums[i], i);
        }
        System.out.println("No complement Number for " + target + " found in array");
        throw new IllegalArgumentException("No two sum solution");
    }


    public static void main(String[] args) {
        int[] nums = {15, 7, 6, 11, 13, 2, 3};
        int target = 9;
        int[] result = twoSum(nums, target);
        System.out.println("Indices of the two numbers: " + result[0] + ", " + result[1]);
    }
}
