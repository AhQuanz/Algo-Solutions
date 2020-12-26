/*
https://leetcode.com/problems/find-words-that-can-be-formed-by-characters/
You are given an array of strings words and a string chars.
A string is good if it can be formed by characters from chars (each character can only be used once).
Return the sum of lengths of all good strings in words.

Input: words = ["cat","bt","hat","tree"], chars = "atach"
Output: 6

Input: words = ["hello","world","leetcode"], chars = "welldonehoneyr"
Output: 10
*/
class WordsFromC{
    public int countCharacters(String[] words, String chars) {
        //Solution 1 - Using Array (Since only lowercase English letters) 
        int[] allowed_o = new int[26];
        for(int i = 0; i < chars.length(); i++) {
            allowed_o[chars.charAt(i) - 'a'] += 1;
        }
        int count = 0;
        for(String word : words) {
            int[] allowed = Arrays.copyOf(allowed_o,allowed_o.length);
            int i = 0;
            for( ; i < word.length();i++) {
                if(allowed[word.charAt(i) - 'a'] == 0) {
                    break;
                } else {
                    allowed[word.charAt(i) - 'a'] -= 1;
                }
            }
            if (i == word.length()){
                count += word.length();
            }
        }
        return count;
        //Solution 2 - Using hashMap (Original intention of Question) 
        /*
        HashMap<Character,Integer>allowed = new HashMap<>();
        for(int i = 0; i < chars.length(); i++) {
            Integer value = allowed.get(chars.charAt(i));
            if (value == null) {
                value = 0;
            }
            allowed.put(chars.charAt(i),++value);
        }
        int count = 0;
        for(String word : words) {
            HashMap<Character,Integer> word_c = new HashMap<>();
            for( int i = 0 ; i < word.length();i++) {
                Integer value = word_c.get(word.charAt(i));
                if (value == null) {
                    value = 0;
                }
                word_c.put(word.charAt(i),++value);
            }
            boolean dup = true;
            for(Character c : word_c.keySet()) {
                if(word_c.get(c) == null || allowed.get(c) == null || word_c.get(c) > allowed.get(c)) {
                    dup = false;
                    break;
                }
            }
            if(dup) {
                count += word.length();
            }
        }
        return count; 

        */
    }
}
