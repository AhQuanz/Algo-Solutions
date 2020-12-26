/*
https://leetcode.com/problems/to-lower-case/
Implement function ToLowerCase() that has a string parameter str, and returns the same string in lowercase.

Input: "Hello"
Output: "hello"

Input: "here"
Output: "here"

Input: "LOVELY"
Output: "lovely"
*/
class ToLowerCase{
    public String toLowerCase(String str) {
        StringBuilder res = new StringBuilder();
        for(int i = 0; i < str.length(); i++) {
            if (str.charAt(i) >= 'A' && str.charAt(i) <= 'Z') {
                res.append((char)(str.charAt(i) + 32));
            }  else {
                res.append(str.charAt(i));
            }
        }
        return res.toString();
    }
}
