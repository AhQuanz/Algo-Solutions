/*
https://leetcode.com/problems/hamming-distance/
The Hamming distance between two integers is the number of positions at which the corresponding bits are different.
Given two integers x and y, calculate the Hamming distance.

Input: x = 1, y = 4
Output: 2
*/
class HamDistance {
    public int hammingDistance(int x, int y) {
        //Bit DIfference? - XOR 
        int res = x ^ y;
        int count = 0;
        while(res != 0) {
            count += (res & 1);
            res >>= 1;
        }
        return count;

        //Solution 2 - InBuild function 
        /*
            return Integer.bitCount(x ^ y); 
        */

        // Solution 3 - Remove nearest 1 bit 
        // https://leetcode-cn.com/problems/hamming-distance/solution/yi-ming-ju-chi-by-leetcode/
        /*
            int xor = x ^ y;
            int distance = 0;
            while (xor != 0) {
                distance += 1;
                 // remove the rightmost bit of '1'
                xor = xor & (xor - 1);
            }
            return distance;
        */
    }
}
