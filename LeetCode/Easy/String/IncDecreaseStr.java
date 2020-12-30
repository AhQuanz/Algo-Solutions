/*
Given a string s. You should re-order the string using the following algorithm:
1 - Pick the smallest character from s and append it to the result.
2 - Pick the smallest character from s which is greater than the last appended character to the result and append it.
3 - Repeat step 2 until you cannot pick more characters.
4 - Pick the largest character from s and append it to the result.
5 - Pick the largest character from s which is smaller than the last appended character to the result and append it.
6 - Repeat step 5 until you cannot pick more characters.
7 - Repeat the steps from 1 to 6 until you pick all characters from s.
In each step, If the smallest or the largest character appears more than once you can choose any occurrence and append it to the result.

Return the result string after sorting s with this algorithm.

Input: s = "aaaabbbbcccc"
Output: "abccbaabccba"

Input: s = "rat"
Output: "art"

Input: s = "leetcode"
Output: "cdelotee"

*/
class IncDecreaseStr{
    public String sortString(String s) {
        int[] arr = new int[26];
        for(int i = 0; i < s.length(); i++) {
            arr[s.charAt(i) - 'a']++;
        }
        StringBuilder res = new StringBuilder();
        int count = s.length();
        while(count > 0) {
            for(int i = 0; i < arr.length; i++) {
                if(arr[i] > 0) {
                    res.append((char)('a' + i));
                    arr[i]--;
                    count--;
                }
            }
            for(int i = arr.length - 1; i >= 0; i--) {
                if(arr[i] > 0) {
                    res.append((char)('a' + i));
                    arr[i]--;
                    count--;
                }
            }
        }
        return res.toString();
    }
}
