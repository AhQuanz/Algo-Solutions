/*
https://leetcode-cn.com/problems/armstrong-number/
ArmStrong number if and only if all digits of N to power of k adds up to N.
k --> number digits 

Input: 153
Output: true

Input: 123
Output: false
*/
class ArmStrongNum {
    public boolean isArmstrong(int N) {
        int num = N, result = 0, len = Integer.toString(N).length(); 
        while(num != 0) {
            result += Math.pow(num%10, len);
            num /= 10;
        }
        return result == N;
    }
}
