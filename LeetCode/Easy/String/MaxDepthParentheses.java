/*
https://leetcode.com/problems/maximum-nesting-depth-of-the-parentheses/
A string is a valid parentheses string (denoted VPS) if it meets one of the following:
It is an empty string "", or a single character not equal to "(" or ")",
It can be written as AB (A concatenated with B), where A and B are VPS's, or
It can be written as (A), where A is a VPS.
We can similarly define the nesting depth depth(S) of any VPS S as follows:
depth("") = 0
depth(C) = 0, where C is a string with a single character not equal to "(" or ")".
depth(A + B) = max(depth(A), depth(B)), where A and B are VPS's.
depth("(" + A + ")") = 1 + depth(A), where A is a VPS.
For example, "", "()()", and "()(()())" are VPS's (with nesting depths 0, 1, and 2), and ")(" and "(()" are not VPS's.

Input: s = "(1+(2*3)+((8)/4))+1"
Output: 3

Input: s = "(1)+((2))+(((3)))"
Output: 3

Input: s = "1+(2*3)/(2-1)"
Output: 1

Input: s = "1"
Output: 0

Input: s = "8*((1*(5+6))*(8/6))"
Output: 2

Given a VPS represented as string s, return the nesting depth of s.
20. Valid Parentheses
22. Generate Parentheses
32. Longest Valid Parentheses
241. Different Ways to Add Parentheses
301. Remove Invalid Parentheses
678. Valid Parenthesis String
856. Score of Parentheses
921. Minimum Add to Make Parentheses Valid
1021. Remove Outermost Parentheses
1111. Maximum Nesting Depth of Two Valid Parentheses Strings
1190. Reverse Substrings Between Each Pair of Parentheses
1249. Minimum Remove to Make Valid Parentheses
1541. Minimum Insertions to Balance a Parentheses String
 */
class MaxDepthParenthesis{
    //Idea - to count the maximum open brackets for every close bracket we meet
    public int maxDepth(String s) {
        int count = 0;
        int count2 = 0;
        for(int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '('){
                count = Math.max(count,++count2);
            } else if (s.charAt(i) == ')'){
                count2 --;
            } 
        }
        return count;
    }
}
