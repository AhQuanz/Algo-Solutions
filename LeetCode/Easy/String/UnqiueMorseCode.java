/*
https://leetcode.com/problems/unique-morse-code-words/
International Morse Code defines a standard encoding where each letter is mapped to a series of dots and dashes, as follows: "a" maps to ".-", "b" maps to "-...", "c" maps to "-.-.", and so on.

For convenience, the full table for the 26 letters of the English alphabet is given below:

[".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."]

Now, given a list of words, each word can be written as a concatenation of the Morse code of each letter. 
For example, "cab" can be written as "-.-..--...", (which is the concatenation "-.-." + ".-" + "-..."). 
We'll call such a concatenation, the transformation of a word.
Return the number of different transformations among all words we have.

Input: words = ["gin", "zen", "gig", "msg"]
Output: 2
Explanation: 
The transformation of each word is:
"gin" -> "--...-."
"zen" -> "--...-."
"gig" -> "--...--."
"msg" -> "--...--."

*/
class UnqiueMorseCode{
    public int uniqueMorseRepresentations(String[] words) {
        String[] arr = new String[] {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        HashSet<String> dup = new HashSet<>();
        for(String str : words) {
            StringBuilder result = new StringBuilder();
            for(int i = 0; i < str.length(); i++) {
                result.append(arr[str.charAt(i) - 'a']);
            }
            dup.add(result.toString());
        }
        return dup.size();
    }
}
