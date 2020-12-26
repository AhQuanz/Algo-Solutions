/*
https://leetcode.com/problems/split-a-string-in-balanced-strings/
Balanced strings are those who have equal quantity of 'L' and 'R' characters.
Given a balanced string s split it in the maximum amount of balanced strings.
Return the maximum amount of splitted balanced strings.

Input: s = "RLRRLLRLRL"
Output: 4

Input: s = "RLLLLRRRLR"
Output: 3

Input: s = "LLLLRRRR"
Output: 1

Input: s = "RLRRRLLRLL"
Output: 2
*/
class BalanceStrSplit{
    public int balancedStringSplit(String s) {
        // Solution 1 - Greedy , just count and when same amount of L and R increase 
        int num_L = 0;
        int num_R = 0;
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'R') {
                num_R += 1;
            } else {
                num_L += 1;
            }
            if (num_R == num_L) {
                count += 1;
            } 
        } 
        return count;
        // Solution 2 - Greedy but uses only 1 variable , L (increase) , R (decrease) , == 0 then increase count 
    } 
}
