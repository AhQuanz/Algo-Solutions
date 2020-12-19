/*
 * https://leetcode.com/problems/how-many-numbers-are-smaller-than-the-current-number/
 * Given the array nums, for each nums[i] find out how many numbers in the array are smaller than it. 
 * That is, for each nums[i] you have to count the number of valid j's such that j != i and nums[j] < nums[i].
 * Return the answer in an array.
 *
 * Test Case 1: 
 * [5,0,10,0,10,6]
 * [2,0,4,0,4,3]
 *
 * Example 1
 * Input: nums = [8,1,2,2,3]
 * Output: [4,0,1,1,3]
 *
 * Example 2:
 * Input: nums = [6,5,4,8]
 * Output: [2,1,0,3]
 *
 * Example 3:
 * Input: nums = [7,7,7,7]
 * Output: [0,0,0,0]
 *
 */
class SmallerNum {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++) {
            max = Math.max(nums[i],max);
        }
        int[] freq = new int[max+1];
        for (int i = 0; i < nums.length; i++) {
            freq[nums[i]] += 1;
        }
        for (int i = 1; i < freq.length; i++) {
            freq[i] += freq[i - 1];
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] - 1 < 0) {
                nums[i] = 0;
            } else {
                nums[i] = freq[nums[i] - 1];
            }
        }
        return nums;
    }
}
