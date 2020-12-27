/*
https://leetcode.com/problems/count-good-triplets/submissions/
Given an array of integers arr, and three integers a, b and c. You need to find the number of good triplets.
A triplet (arr[i], arr[j], arr[k]) is good if the following conditions are true:
0 <= i < j < k < arr.length
|arr[i] - arr[j]| <= a
|arr[j] - arr[k]| <= b
|arr[i] - arr[k]| <= c
Where |x| denotes the absolute value of x.
Return the number of good triplets.

Input: arr = [3,0,1,1,9,7], a = 7, b = 2, c = 3
Output: 4

Input: arr = [1,1,2,2,3], a = 0, b = 0, c = 1
Output: 0
*/
class CountGdTri{
    public int countGoodTriplets(int[] arr, int a, int b, int c) {
        //Idea find i and j first
        //ArrList loop is O(n^2) to generate n choose 2 combinations 
        //finding K would need to loop thru n choose combinations 
        ArrayList<int[]> arrList = new ArrayList<>();
        for(int i = 0; i < arr.length; i++) {
            for(int j = i + 1; j < arr.length; j++) {
                if( Math.abs(arr[i] - arr[j]) <= a) {
                    arrList.add(new int[] {i,j});
                }
            }
        } 
        int count = 0;
        for(int k = 0; k < arr.length; k++){
            for(int[] duo : arrList) {
                if (k > duo[0] && k > duo[1]) {
                    boolean e_b = Math.abs(arr[duo[1]] - arr[k]) <= b;
                    boolean e_c = Math.abs(arr[duo[0]] - arr[k]) <= c;
                    count = (e_b && e_c) ? count + 1 : count;
                }
            }
        }
        return count;

        //Easier solution, brute force O(n^3) constrains are small
        /*
        int count = 0;
        for (int i = 0; i < arr.length-2; i++) {
            for(int j = i+1; j < arr.length-1; j++) {
                if(Math.abs(arr[i] - arr[j]) <= a) {
                    for(int k = j+1; k < arr.length; k++) {
                        if(Math.abs(arr[j] - arr[k]) <= b && Math.abs(arr[i] - arr[k]) <= c) {
                            count += 1;
                        }
                    }
                }
            }
        }
        return count; */
    }
}
