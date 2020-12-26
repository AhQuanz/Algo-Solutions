/*
https://leetcode.com/problems/count-of-matches-in-tournament/
You are given an integer n, the number of teams in a tournament that has strange rules:
If the current number of teams is even, each team gets paired with another team. 
A total of n / 2 matches are played, and n / 2 teams advance to the next round.
If the current number of teams is odd, one team randomly advances in the tournament, 
and the rest gets paired. A total of (n - 1) / 2 matches are played, and (n - 1) / 2 + 1 teams advance to the next round.
Return the number of matches played in the tournament until a winner is decided.

Input: n = 7
Output: 6

Input: n = 14
Output: 13

*/
class CountMatches{
    //Solution 1 - O(log n) (recursive)
    public int numberOfMatches(int n) {
        if(n <= 1) {
            return 0;
        } else if(n % 2 == 0 ){
            return n/2 + numberOfMatches(n/2);
        } else {
            return (n-1) / 2 + numberOfMatches((n-1)/2 + 1);
        }
    }
    //Solution 2 - O(1) Every match , 1 team loses so champion has to win over n - 1 teams 
    // return n-1;
}
