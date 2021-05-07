/*
https://leetcode.com/problems/remove-duplicates-from-sorted-array/

Given a sorted array nums, remove the duplicates in-place such that each element appears only once 
and returns the new length.

Do not allocate extra space for another array, you must do this by modifying the input array in-place 
with O(1) extra memory.

Input: nums = [1,1,2]
Output: 2, nums = [1,2]

Input: nums = [0,0,1,1,1,2,2,3,3,4]
Output: 5, nums = [0,1,2,3,4]

*/
class RemoveDups {
    public int removeDuplicates(int[] nums) {
        int uniqueIndex = 0;
        for(int i = 0; i < nums.length; i++ ){
            if(nums[uniqueIndex] != nums[i]) {
                nums[++uniqueIndex] = nums[i];
            }
        }
        return uniqueIndex + 1;
    }
}
