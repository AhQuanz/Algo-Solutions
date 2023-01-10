/*
  https://leetcode.com/problems/product-of-array-except-self/description/
  Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].

  The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.

  You must write an algorithm that runs in O(n) time and without using the division operation.

  Example 1:

  Input: nums = [1,2,3,4]
  Output: [24,12,8,6]
  Example 2:

  Input: nums = [-1,1,0,-3,3]
  Output: [0,0,9,0,0]

*/
class ProductOfArrayExceptSelf {
  public int[] productExceptSelf(int[] nums) {
    int[] prefix = new int[nums.length];
    int[] posfix = new int[nums.length];
    prefix[0] = nums[0];
    
    for(int i = 1 ; i < nums.length; i++) {
        prefix[i] = prefix[i - 1] * nums[i];
    }
    
    posfix[nums.length - 1] = nums[nums.length - 1];
    
    for(int i = nums.length - 2; i > 0; i--) {
        posfix[i] = posfix[i + 1] * nums[i];
    }
    
    int[] res = new int[nums.length];
    for(int i = 0; i < nums.length; i++) {
        if(i == 0) {
            res[i] = posfix[i + 1];
        } else if (i == nums.length - 1) {
            res[i] = prefix[i - 1];
        } else {
            res[i] = prefix[i - 1] * posfix[i+1];
        }
    }
    return res;
  } 
}