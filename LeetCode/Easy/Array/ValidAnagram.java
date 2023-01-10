/*
  https://leetcode.com/problems/valid-anagram/description/

  Given two strings s and t, return true if t is an anagram of s, and false otherwise.

  An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.

  Example 1:
  Input: s = "anagram", t = "nagaram"
  Output: true

  Example 2:
  Input: s = "rat", t = "car"
  Output: false

 */

 class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        HashMap<Character,Integer> sCharMap = new HashMap<>();

        for(char c : s.toCharArray()) {
            Integer count = sCharMap.get(c);

            if(count == null) {
                count = 0;
            }
            sCharMap.put(c, count + 1);
        }
        
        for(char c : t.toCharArray()) {
            Integer count = sCharMap.get(c);
            if(count == null) {
                return false;
            } else if (count > 1) {
                sCharMap.put(c, count - 1);
            } else {
                sCharMap.remove(c);
            }
        }
        return true;
    }
}