//https://leetcode.com/problems/running-sum-of-1d-array/

/*
Example 1:

Input: nums = [1,2,3,4]
Output: [1,3,6,10]
Explanation: Running sum is obtained as follows: [1, 1+2, 1+2+3, 1+2+3+4].

Example 2:
Input: nums = [1,1,1,1,1]
Output: [1,2,3,4,5]
Explanation: Running sum is obtained as follows: [1, 1+1, 1+1+1, 1+1+1+1, 1+1+1+1+1].

Example 3:
Input: nums = [3,1,2,10,1]
Output: [3,4,6,16,17] */

class RunningSum {
    public int[] runningSum(int[] nums) {
        /*
         *  O(1) space solution 
         *  
         *  for (int i = 1; i < nums.length; i++) {
         *      nums[i] = nums[i] + nums[i - 1];
         *  }
         */
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            nums[i] = sum;
        }
        return nums;
    }
}