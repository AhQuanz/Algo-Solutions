/*
https://leetcode.com/problems/find-numbers-with-even-number-of-digits/
Given an array nums of integers, return how many of them contain an even number of digits.

Input: nums = [12,345,2,6,7896]
Output: 2

Input: nums = [555,901,482,1771]
Output: 1 
*/
class EvenNumDigits{
    public int findNumbers(int[] nums) {
        int count = 0;
        for(int n : nums) {
            int digit = 0;
            while (n > 0) {
                n /= 10;
                digit += 1;
            }
            if(digit %2 == 0) {
                count += 1;
            }
        }
        return count;
    }
}
