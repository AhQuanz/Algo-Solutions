/*
https://leetcode-cn.com/problems/remove-vowels-from-a-string/
remove the vowels 'a', 'e', 'i', 'o', and 'u' from it, and return the new string.

*/
class removeVowelsStr {
    public String removeVowels(String s) {
        HashSet<Character> h = new HashSet<>(List.of('a','e','i','o','u'));
        StringBuilder res = new StringBuilder();
        for(int i = 0; i < s.length(); i++) {
            if(!h.contains(s.charAt(i))) {
                res.append(s.charAt(i));
            }
        }
        return res.toString();
    }
}
