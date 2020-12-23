/*
https://leetcode.com/problems/shuffle-string/
Given a string s and an integer array indices of the same length.
The string s will be shuffled such that the character at the ith position moves to indices[i] in the shuffled string.
Return the shuffled string.

Input: s = "codeleet", indices = [4,5,6,7,0,2,1,3]
Output: "leetcode"

Input: s = "abc", indices = [0,1,2]
Output: "abc"

Input: s = "aiohn", indices = [3,1,4,2,0]
Output: "nihao"

Input: s = "aaiougrt", indices = [4,0,2,6,7,3,1,5]
Output: "arigatou"

Input: s = "art", indices = [1,0,2]
Output: "rat

*/
class ShuffleStr {
    public String restoreString(String s, int[] indices) {
        /*
         * Solution 2 (Character array)  
           char[] arr = new char[indices.length];
            for(int i = 0; i < indices.length; i++) {
                arr[indices[i]] = s.charAt(i);
            }
            return new String(arr);         
        */
        PriorityQueue<duo> PQ = new PriorityQueue<>();
        for(int i = 0; i < indices.length; i++){
            PQ.add(new duo(indices[i],s.charAt(i)));
        }
        StringBuilder result = new StringBuilder();
        while (!PQ.isEmpty()) {
            duo front = PQ.poll();
            result.append(front.letter);
        }
        return result.toString();
    }
}

class duo implements Comparable<duo> {
    public int index;
    public char letter;

    public duo(int index, char letter) {
        this.index = index;
        this.letter = letter;
    }

    public int compareTo(duo other) {
        return this.index - other.index;
    }
}
