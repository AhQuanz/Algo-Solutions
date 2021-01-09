/*
https://leetcode.com/problems/maximum-69-number/
Given a positive integer num consisting only of digits 6 and 9.
Return the maximum number you can get by changing at most one digit (6 becomes 9, and 9 becomes 6).

Input: num = 9669
Output: 9969

Input: num = 9996
Output: 9999

Input: num = 9999
Output: 9999
*/
class Max69Num {
    public int maximum69Number (int num) {
        //Idea is to not use String 
        //We keep track of the 6 towards the left side of the number 
        int counter = -1, i = 0, temp = num;
        while(temp > 0) {
            if(temp % 10 == 6) {
                counter = i;
            } 
            temp /= 10;
            i++;
        }
        return (int) (num + 3 * Math.pow(10, counter));            
    }
}
