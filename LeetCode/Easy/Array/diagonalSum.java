/*
https://leetcode.com/problems/matrix-diagonal-sum/
Given a square matrix mat, return the sum of the matrix diagonals.
Only include the sum of all the elements on the primary diagonal and all the elements on the secondary diagonal that are not part of the primary diagonal.

Input: mat = [[1,2,3],
              [4,5,6],
              [7,8,9]]
Output: 25

Input: mat = [[1,1,1,1],
              [1,1,1,1],
              [1,1,1,1],
              [1,1,1,1]]
Output: 8

Input: mat = [[5]]
Output: 5
*/
class diagonalSum{
    public int diagonalSum(int[][] mat) {
        int sum = 0, i = 0;
        for(; i < mat.length ; i++) {
            sum += mat[i][i] + mat[mat.length-1-i][i];
        }
        return (mat.length % 2 == 0) ? sum : sum - mat[mat.length>>1][mat.length>>1];
    }
}
