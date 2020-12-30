/*
https://leetcode.com/problems/number-of-students-doing-homework-at-a-given-time/
Given two integer arrays startTime and endTime and given an integer queryTime.
The ith student started doing their homework at the time startTime[i] and finished it at time endTime[i].
Return the number of students doing their homework at time queryTime. 
More formally, return the number of students where queryTime lays in the interval [startTime[i], endTime[i]]
inclusive.

Input: startTime = [1,2,3], endTime = [3,2,7], queryTime = 4
Output: 1

Input: startTime = [4], endTime = [4], queryTime = 4
Output: 1

Input: startTime = [4], endTime = [4], queryTime = 5
Output: 0

Input: startTime = [1,1,1,1], endTime = [1,3,2,4], queryTime = 7
Output: 0

Input: startTime = [9,8,7,6,5,4,3,2,1], endTime = [10,10,10,10,10,10,10,10,10], queryTime = 5
Output: 5

*/
class numStdDoingWork{
    public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
        int count = startTime.length;
        for(int i = 0; i < startTime.length; i++) {
            if(queryTime > endTime[i] || queryTime < startTime[i]) {
                count--;
            }
        }
        return count;
    }
}
