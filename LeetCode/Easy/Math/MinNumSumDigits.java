/*
https://leetcode-cn.com/problems/sum-of-digits-in-the-minimum-number/
Find minimal element of A and sum up all its digits. 
If sum is odd return 0 , else return 1;

Input: [34,23,1,24,75,33,54,8]
Output: 0

Input: [99,77,33,66,55]
Output: 1

Input : [89,93,84,87,17,4,92,26,99,29,100,85,82,52,76,27,40,69,21,92,89,36]
Output: 1

*/
class MinNumSumDigits {
    public int sumOfDigits(int[] A) {
        int n = A[0], res  = 0;
        for (int num : A) {
            if (n > num) {
                n = num;
            }
        }
        while (n != 0) {
            res += n%10;
            n /= 10;
        }
        return res  % 2 == 0 ? 1 : 0;
    } 
}
