/*
https://leetcode.com/problems/remove-outermost-parentheses/
A valid parentheses string is either empty (""), "(" + A + ")", or A + B, where A and B are valid parentheses strings, and + represents string concatenation.  
For example, "", "()", "(())()", and "(()(()))" are all valid parentheses strings.
A valid parentheses string S is primitive if it is nonempty
and there does not exist a way to split it into S = A+B, with A and B nonempty valid parentheses strings.
Given a valid parentheses string S, consider its primitive decomposition: S = P_1 + P_2 + ... + P_k, where P_i are primitive valid parentheses strings.
Return S after removing the outermost parentheses of every primitive string in the primitive decomposition of S.

Input: "(()())(())"
Output: "()()()"

Input: "(()())(())(()(()))"
Output: "()()()()(())"

Input: "()()"
Output: ""
*/
class RemoveOuterParentheses {
    public String removeOuterParentheses(String S) {
        int count = 0;
        StringBuilder result = new StringBuilder();
        for(int i = 0; i < S.length(); i++) {
            if(S.charAt(i) == '(') {
                if (count > 0) {
                    result.append(S.charAt(i));
                }
                count++;
            } else if (S.charAt(i) == ')' && count-- > 1) {
                result.append(S.charAt(i));
            }
        }
        return result.toString();
    }
}
