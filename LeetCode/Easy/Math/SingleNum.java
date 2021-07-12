/*
Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.

Follow up: Could you implement a solution with a linear runtime complexity and without using extra memory?

Input: nums = [2,2,1]
Output: 1

Input: nums = [4,1,2,1,2]
Output: 4

Input: nums = [1]
Output: 1
*/
public class SingleNum {
    public int singleNumber(int[] nums) {
        int sum = 0;
        for( int num : nums ) {
            sum ^= num;
        }
        return sum;
    }
}
