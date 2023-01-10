/*
https://leetcode.com/problems/group-anagrams/description/

Given an array of strings strs, group the anagrams together. You can return the answer in any order.

An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.

Example 1:

Input: strs = ["eat","tea","tan","ate","nat","bat"]
Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
Example 2:

Input: strs = [""]
Output: [[""]]
Example 3:

Input: strs = ["a"]
Output: [["a"]]

*/
class groupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();

        HashMap<String , ArrayList<String>> hm = new HashMap<>();
        for(int i = 0; i < strs.length; i++) {
            char[] s = strs[i].toCharArray();
            Arrays.sort(s);
            String sorted = new String(s);
            if(hm.containsKey(sorted)) {
                hm.get(sorted).add(strs[i]);
            } else {
                ArrayList<String> temp = new ArrayList<>();
                temp.add(strs[i]);
                hm.put(sorted, temp);
            }
        }
        for(List<String> s : hm.values()) {
            res.add(s);
        }
        return res;
    }
}