/*
https://leetcode.com/problems/count-negative-numbers-in-a-sorted-matrix/
Given a m x n matrix grid which is sorted in non-increasing order both row-wise and column-wise
return the number of negative numbers in grid.

Input: grid = [[4,3,2,-1],[3,2,1,-1],[1,1,-1,-2],[-1,-1,-2,-3]]
Output: 8

Input: grid = [[3,2],[1,0]]
Output: 0

Input: grid = [[1,-1],[-1,-1]]
Output: 3

Input: grid = [[-1]]
Output: 1

*/
class CountNegNum {
    public int countNegatives(int[][] grid) {
        //Idea is to count starting from top right to bottom left. 
        int count = 0;
        int l = grid[0].length - 1;
        int r = l;
        for(int i = 0; i < grid.length; i++) {
            for(; r >= 0; r--) {
                if(grid[i][r] >= 0) {
                    break;
                }
            }
            count += (l - r);
        }
        return count;
    }
}
