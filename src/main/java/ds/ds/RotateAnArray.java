package ds.ds;

/*
 * Problem: Rotate an array of n elements to the right by k steps. For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].
 * How many different ways do you know to solve this problem?
 * */

/*
Can we do this in O(1) space and in O(n) time? The following solution does. Assuming we are given 1,2,3,4,5,6 and order 2. The basic idea is:
1. Divide the array two parts: 1,2,3,4 and 5, 6
2. Reverse first part: 4,3,2,1,5,6
3. Reverse second part: 4,3,2,1,6,5
4. Reverse the whole array: 5,6,1,2,3,4

* */
public class RotateAnArray {

  public static void main(String[] args) {

    rotate(new int[]{1, 2, 4, 5, 6,}, 3);
  }

  static void rotate(int[] nums, int k) {
    //Step1 : check if array is not null & k is less than nums.length
    if (nums == null || nums.length == 0 || k < 0) {
      throw new IllegalArgumentException();
    }

    int primelen = nums.length - k;
    reverse(nums, 0, primelen - 1);
    reverse(nums, primelen, nums.length - 1);
    reverse(nums, 0, nums.length - 1);
    for (int num : nums)
      System.out.print(" " + num);
  }

  static void reverse(int[] nums, int left, int right) {
    if (nums == null || nums.length == 1) {
      return;
    }
    while (left < right) {
      int temp = nums[left];
      nums[left] = nums[right];
      nums[right] = temp;
      left++;
      right--;
    }
  }

}
