/*
https://leetcode.com/problems/replace-elements-with-greatest-element-on-right-side/

Given an array arr, replace every element in that array with the greatest element 
among the elements to its right, and replace the last element with -1.
After doing so, return the array.

Input: arr = [17,18,5,4,6,1]
Output: [18,6,6,6,1,-1]

Input: arr = [400]
Output: [-1]

*/
class GreatestElmOnRight {
    public int[] replaceElements(int[] arr) {
        int greatest = arr[arr.length - 1];
        int[] res = new int[arr.length];
        for(int i = arr.length - 1; i >= 0; i--) {
            res[i] = greatest;
            if (greatest < arr[i]) {
                greatest = arr[i]; 
            }
        }
        res[arr.length - 1] = -1;
        return res;
    }
}
