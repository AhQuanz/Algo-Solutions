/*
https://leetcode-cn.com/problems/find-anagram-mappings/
2 List , B is anagram of A
Return an array containing the index mapping of every element of A in B. 

A = [12, 28, 46, 32, 50]
B = [50, 12, 32, 46, 28]
[1, 4, 3, 2, 0]

*/
class AnagramMapping{
    public int[] anagramMappings(int[] A, int[] B) {
        //Solution - HashMap , O(1) loop up , O(N) solution 
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < B.length; i++) {
            map.put(B[i],i);
        }
        int[] arr = new int[A.length];
        for(int i = 0; i < A.length; i++) {
            arr[i] = map.get(A[i]);
        }
        return arr;
    }
}
