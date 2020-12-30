/*
 * https://leetcode.com/problems/number-of-steps-to-reduce-a-number-to-zero
 * Given a non-negative integer num, return the number of steps to reduce it to zero. 
 * If the current number is even, you have to divide it by 2, 
 * otherwise, you have to subtract 1 from it.
 *
 * Example 1:
 * Input: num = 14
 * Output: 6
 *
 * Example 2:
 * Input: num = 8
 * Output: 4
 *
 * Example 3:
 * Input: num = 123
 * Output: 12
 */

class numSteps {
    public int numberOfSteps (int num) {
        int count = 0;
        while (num >= 1) {
            if (num % 2 == 0) {
                num >>= 1;
            } else {
                num -= 1;
            }
            count++;
        }
        return count;

        /*
         * Solution 2 (recursion)  
            if (num == 0) {
                return 0;
            } else if ( num % 2 == 0) {
                return numberOfSteps(num >> 1) + 1;
            } else {
                return numberOfSteps(num - 1) + 1;
            }        
        */
        /*
        Solution 3 (count 1 and 0) 
        if (num == 0) {
            return 0;
        } else {
            int count = 0;
            while(num != 0) {
                count += (num & 1) == 0 ? 1 : 2;
                num >>= 1;
            }
            return count - 1;
        }        
        */
    }
}
