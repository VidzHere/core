package ds.twoPtr;


import java.util.HashMap;
import java.util.Map;

/*
Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.
Example 1:
Input: nums = [1,1,1,2,2,3], k = 2
Output: [1,2]
Example 2:

Input: nums = [1], k = 1
Output: [1]
* */
public class MostKFrequentElements {

    public static void main(String[] args) {
        Integer[] nums = {1, 1, 1, 2, 2, 3, 3, 4, 5, 5};
        int k = 2;
        mostFrequentKElements(nums, k);
    }

    static void mostFrequentKElements(Integer[] nums, int k) {
        final Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : nums) {
            if (frequencyMap.containsKey(num)) {
                Integer count = frequencyMap.get(num) + 1;
                frequencyMap.put(num, count);
            } else {
                frequencyMap.put(num, 1);
            }
        }
        frequencyMap.forEach((key, value) -> {
            if (value >= k)
                System.out.println("Key : " + key + " value : " + value);
        });
    }
}