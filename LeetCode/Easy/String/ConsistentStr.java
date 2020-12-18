import java.util.*;
import java.io.*;

/*
  https://leetcode.com/problems/count-the-number-of-consistent-strings/    
  You are given a string allowed consisting of distinct characters and an array of strings words.
  A string is consistent if all characters in the string appear in the string allowed.
  Return the number of consistent strings in the array words.
  
  Example 1:
  Input: allowed = "ab", words = ["ad","bd","aaab","baa","badab"]
  Output: 2

  Example 2:
  Input: allowed = "abc", words = ["a","b","c","ab","ac","bc","abc"]
  Output: 7

  Example 3:
  Input: allowed = "cad", words = ["cc","acd","b","ba","bac","bad","ac","d"]
  Output: 4

*/
class ConsistentStr {
    public int countConsistentStrings(String allowed, String[] words) {
        //Solution 1 (HashMap) 
        HashMap<Character,Character> allowed_c = new HashMap<>();
        for(int i = 0; i < allowed.length(); i++) {
            allowed_c.put(allowed.charAt(i),allowed.charAt(i));
        }
        int count = 0;
        for(String str : words) {
            int i = 0;
            for(; i < str.length(); i++) {
                if (allowed_c.get(str.charAt(i)) == null) {
                    break;
                }
            }
            if (i == str.length()) {
                count++;
            }
        }
        return count;

        //Solution 2 (HashSet) 
        /*
        HashSet<Character> allowed_c = new HashSet<>();
        for(int i = 0; i < allowed.length(); i++) {
            allowed_c.add(allowed.charAt(i));
        }
        int count = 0;
        for(String str : words) {
            int i = 0;
            for(; i < str.length(); i++) {
                if (!allowed_c.contains(str.charAt(i))) {
                    break;
                }
            }
            if (i == str.length()) {
                count++;
            }
        }
        return count;
        */
        
        //Solution 3 (BitSet) 
        /*
        BitSet allowed_c = new BitSet();
        for(int i = 0; i < allowed.length(); i++) {
            int index = allowed.charAt(i) - 'a';
            allowed_c.set(index);
        }
        int count = words.length;
        for(String str : words) {
            for(int i = 0; i < str.length(); i++) {
                if (!allowed_c.get(str.charAt(i)- 'a')) {
                    count--;
                    break;
                }
            }
        }
        return count;
        
         */
    } 
}
