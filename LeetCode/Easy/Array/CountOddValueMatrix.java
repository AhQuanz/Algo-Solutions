/*
https://leetcode.com/problems/cells-with-odd-values-in-a-matrix/
Given n and m which are the dimensions of a matrix initialized by zeros and given an array indices where indices[i] = [ri, ci]. 
For each pair of [ri, ci] you have to increment all cells in row ri and column ci by 1.
Return the number of cells with odd values in the matrix after applying the increment to all indices.

Input: n = 2, m = 3, indices = [[0,1],[1,1]]
Output: 6
Explanation: Initial matrix = [[0,0,0],[0,0,0]].
After applying first increment it becomes [[1,2,1],[0,1,0]].
The final matrix will be [[1,3,1],[1,3,1]] which contains 6 odd numbers.

Input: n = 2, m = 2, indices = [[1,1],[0,0]]
Output: 0
*/
class CountOddValueMatrix {
    public int oddCells(int n, int m, int[][] indices) {
        //Solution 1 - brute force O(m * n + L) 
        /*
        int[][] result = new int[n][m];
        int count = 0;
        for(int[] arr : indices) {
            for(int i = 0; i < m; i++) {
                result[arr[0]][i] += 1;
            }
            for(int i = 0; i < n; i++) {
                result[i][arr[1]] += 1;
            }
        }

        for(int[] test: result) {
            for(Integer i : test) {
                count = i % 2 != 0 ? count + 1 : count;
            }
        }
        return count;
        */
        // Solution 2 - we count the number of times it appears 
        // O(L + m + n) L = indices.length;
        BitSet row = new BitSet(n) , col = new BitSet(m);
        for(int[] arr : indices) {
            row.flip(arr[0]);
            col.flip(arr[1]);
        }
        
        int r = row.cardinality(), c = col.cardinality();
        
        return r*m + n*c - 2 * r * c;
    }
}
