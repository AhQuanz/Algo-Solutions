/*
https://leetcode-cn.com/problems/single-row-keyboard/
keyboard is the layout of the keyboard 
starting from 0 complete typing of word 

Input: keyboard = "abcdefghijklmnopqrstuvwxyz", word = "cba"
Output: 4

Input: keyboard = "pqrstuvwxyzabcdefghijklmno", word = "leetcode"
Output: 73
*/
class SingleRowKB {
    public int calculateTime(String keyboard, String word) {
        //Solution 1 - HashMap O(N) 
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i = 0; i < keyboard.length(); i++) {
            map.put(keyboard.charAt(i),i);
        }
        int count = map.get(word.charAt(0));
        for(int i = 1; i < word.length(); i++) {
            count += Math.abs(map.get(word.charAt(i)) - map.get(word.charAt(i-1)));
        }
        return count;
        //Solution 2 - int array O(N)
        /*
        int[] arr = new int[26];
        for(int i = 0; i < keyboard.length(); i++) {
            arr[keyboard.charAt(i) - 'a'] = i;
        }
        int count = arr[word.charAt(0) - 'a'];
        for(int i = 1; i < word.length(); i++) {
            count += Math.abs(arr[word.charAt(i) - 'a'] - arr[word.charAt(i-1) - 'a']);
        }
        return count;
        */
    }
}
