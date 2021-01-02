/*
https://leetcode-cn.com/problems/largest-subarray-length-k/
An array A is larger than some array B if for the first index i where A[i] != B[i], A[i] > B[i].

A subarray is a contiguous subsequence of the array.
Given an integer array nums of distinct integers, return the largest subarray of nums of length k.

Input: nums = [1,4,5,2,3], k = 3
Output: [5,2,3]

Input: nums = [1,4,5,2,3], k = 4
Output: [4,5,2,3]

Input: nums = [1,4,5,2,3], k = 1
Output: [5]

*/
class LargestKsubArr{
    public int[] largestSubarray(int[] nums, int k) {
        int max = nums.length - k; 
        for(int i = max; i >= 0; i--) {
            if(nums[i] > nums[max]){
                max = i;
            }
        }
        int count = 0;
        int[] res = new int[k];
        while (count < k) {
            res[count] = nums[max+count];
            count++;
        }
        return res;
    }
}
