/*
https://leetcode.com/problems/minimum-time-visiting-all-points/
On a 2D plane, there are n points with integer coordinates points[i] = [xi, yi]. Return the minimum time in seconds to visit all the points in the order given by points.
You can move according to these rules:
In 1 second, you can either:
    move vertically by one unit,
    move horizontally by one unit, or
    move diagonally sqrt(2) units (in other words, move one unit vertically then one unit horizontally in 1 second).

You have to visit the points in the same order as they appear in the array.
You are allowed to pass through points that appear later in the order, but these do not count as visits.

Input: points = [[1,1],[3,4],[-1,0]]
Output: 7

Input: points = [[3,2],[-2,2]]
Output: 5
*/
class MinTimeVisitPts{
    public int minTimeToVisitAllPoints(int[][] points) {
        int time = 0;
        //Idea - either vertical or diagonally. Each reduces the distance by 1. 
        //Assume we always take diagonal steps first , then the numbero f diagonal is min(dif_x,dif_y) 
        //then vertical steps will be min(dif_x,dif_y) + Math.abs(dif_x,dif_y) 
        //But since the difference is d_x , d_y then maximum number of steps cannot exceed the larger of them. 
        for(int i = 1; i < points.length; i++) {
            int[] cur = points[i-1];
            int d_x = Math.abs(cur[0] - points[i][0]);
            int d_y = Math.abs(cur[1] - points[i][1]);
            time += Math.max(d_x,d_y);
        }
        return time;
    }
}
