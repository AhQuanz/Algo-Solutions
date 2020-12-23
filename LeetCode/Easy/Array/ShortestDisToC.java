/*
https://leetcode.com/problems/shortest-distance-to-a-character/
Given a string S and a character C, return an array of integers 
representing the shortest distance from the character C in the string.

Input: S = "loveleetcode", C = 'e'
Output: [3, 2, 1, 0, 1, 0, 0, 1, 2, 2, 1, 0]

input : S = "abaa" C = "b"
output : [1,0,1,2]
*/
class ShortestDisToC {
    public int[] shortestToChar(String S, char C) {
        int[] result = new int[S.length()];
        int prev = Integer.MAX_VALUE;
        for(int i = 0; i < S.length(); i++) {
            if(S.charAt(i) != C) {
                result[i] = Math.abs(prev - i);
            } else {
                prev = i;
                result[i] = 0;
            }
        }
        prev = Integer.MAX_VALUE;
        for(int i = S.length() - 1; i >= 0; i--) {
            if(S.charAt(i) != C) {
                result[i] = Math.min(result[i], prev - i);
            } else {
                prev = i;
            }
        }
        return result;
    }
}
