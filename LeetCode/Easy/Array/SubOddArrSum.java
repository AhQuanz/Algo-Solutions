/*
https://leetcode.com/problems/sum-of-all-odd-length-subarrays/
Given an array of positive integers arr, calculate the sum of all possible odd-length subarrays.
A subarray is a contiguous subsequence of the array.
Return the sum of all odd-length subarrays of arr.

Input: arr = [1,4,2,5,3]
Output: 58

Input: arr = [1,2]
Output: 3

Input: arr = [10,11,12]
Output: 66
*/
class SubOddArrSum {
    public int sumOddLengthSubarrays(int[] arr) {
        // [1,4,2,5,3]
        // added --> [2,3,4,3,2]
        // https://youtu.be/J5IIH35EBVE
        // https://leetcode.com/problems/sum-of-all-odd-length-subarrays/discuss/854184/JavaC%2B%2BPython-O(N)-Time-O(1)-Space
        // (arr.length - i) * (i + 1) 
        // (how many sub-array start with a[i]) * (how many array end with a[i])
        // for 1 --> 5 (0,01,012,0123,01234) , 1 (0)
        // for 4 --> 4 (1,12,123,1234) , 2 (01,1)

        int result = 0;
        for(int i = 0; i < arr.length; i++) {
            result += ((arr.length-i) * (i+1) + 1) / 2  * arr[i];
        } 
        return result;
    } 
}
