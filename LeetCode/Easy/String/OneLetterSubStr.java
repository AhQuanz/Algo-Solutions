/*
https://leetcode-cn.com/problems/count-substrings-with-only-one-distinct-letter/
Count Substrings that has only 1 distinct letter 

Input: S = "aaaba"
Output: 8

Input: S = "aaaaaaaaaa"
Output: 55
*/
class OneLetterSubStr {
    public int countLetters(String S) {
        int count = 0;
        int length = 1; 
        for(int i = 1; i < S.length(); i++) {
            if (S.charAt(i) == S.charAt(i-1)) {
                length++;
            } else {
                count += (length*(length+1))/2;
                length = 1;
            }
        }
        count += (length*(length+1))/2;
        return count;
    }
}
