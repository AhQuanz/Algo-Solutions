/*
https://leetcode.com/problems/check-if-two-string-arrays-are-equivalent/
Given two string arrays word1 and word2, return true if the two arrays represent the same string, and false otherwise.
A string is represented by an array if the array elements concatenated in order forms the string.

Input: word1 = ["ab", "c"], word2 = ["a", "bc"]
Output: true

Input: word1 = ["a", "cb"], word2 = ["ab", "c"]
Output: false

Input: word1  = ["abc", "d", "defg"], word2 = ["abcddefg"]
Output: true
*/
class CheckStrArr{
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        StringBuilder str1 = new StringBuilder();
        StringBuilder str2 = new StringBuilder();
        for (String str : word1) {
            str1.append(str);
        }
        for (String str : word2) {
            str2.append(str);
        }
        return str1.compareTo(str2) == 0;
    }
}
