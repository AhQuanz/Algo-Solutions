/*
https://leetcode.com/problems/plus-one/

Given a non-empty array of decimal digits representing a non-negative integer, increment one to the integer.

The digits are stored such that the most significant digit is at the head of the list, and each element in the array contains a single digit.

You may assume the integer does not contain any leading zero, except the number 0 itself.

Input: digits = [1,2,3]
Output: [1,2,4]

Input: digits = [4,3,2,1]
Output: [4,3,2,2]

Input: digits = [0]
Output: [1]

*/
class PlusOne {
   public int[] plusOne(int[] digits) {
        Stack<Integer> array = new Stack<>();
        boolean isAdded = false;
        for(int i = digits.length - 1; i >= 0; i--) {
            if (!isAdded) {
                if (digits[i] == 9) {
                    array.push(0);
                } else {
                    array.push(digits[i] + 1);
                    isAdded = true;
                }
            } else {
                array.push(digits[i]);
            }
        }
        if(!isAdded) {
            array.push(1);
        }
        int[] res = new int[array.size()];
        for(int i = 0; i < res.length; i++) {
            res[i] = array.pop();
        }
        return res;

        /*
            Solution 2 (without stack) 
            
            int len = digits.length;
            for(int i = len - 1; i >= 0; i--) {
                digits[i]++;
                digits[i] %= 10;
                if(digits[i]!=0)
                    return digits;
            }
            digits = new int[len + 1];
            digits[0] = 1;
            return digits;

        */
    } 
}
