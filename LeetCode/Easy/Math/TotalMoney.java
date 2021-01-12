/*
https://leetcode.com/problems/calculate-money-in-leetcode-bank/

Hercy wants to save money for his first car. He puts money in the Leetcode bank every day.
He starts by putting in $1 on Monday, the first day. 
Every day from Tuesday to Sunday, he will put in $1 more than the day before. On every subsequent Monday, he will put in $1 more than the previous Monday.
Given n, return the total amount of money he will have in the Leetcode bank at the end of the nth day.

Input: n = 4
Output: 10

Input: n = 10
Output: 37

Input: n = 20
Output: 96
*/
class TotalMoney {
    public int totalMoney(int n) {
        int sets = n/7 , last_set = n % 7, res = 0, i = 1;
        for(; i < sets + 1; i++) {
            res += 7/2.0 * (2* i + 7 - 1);
        }
        res += last_set / 2.0 * (2 * i + last_set - 1);
        return res;
    }
}
