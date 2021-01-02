/*
Given the array of integers nums, you will choose two different indices i and j of that array. 
Return the maximum value of (nums[i]-1)*(nums[j]-1)

Input: nums = [3,4,5,2]
Output: 12 

Input: nums = [1,5,4,5]
Output: 16

Input: nums = [3,7]
Output: 12

Input: nums = [10,1,8,4,7,7,3,6]
Output: 63 

*/
class MaxTwoProduct {
    public int maxProduct(int[] nums) {
        int m = 0, m1 = nums.length-1;
        for (int i = 0, j = nums.length-1; i < nums.length; i++, j--) {
            if(nums[m] < nums[i] && i != m1) {
                m = i;
            }

            if(j != m && nums[m1] < nums[j]) {
                m1 = j;
            }
        }
        return (nums[m] - 1) * (nums[m1] - 1);
    }
}
