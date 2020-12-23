/*
Given two arrays of integers nums and index. 
Your task is to create target array under the following rules:
Initially target array is empty.
From left to right read nums[i] and index[i], insert at index index[i] the value nums[i] in target array.
Repeat the previous step until there are no elements to read in nums and index.
Return the target array.

It is guaranteed that the insertion operations will be valid.

Example 1:
Input: nums = [0,1,2,3,4], index = [0,1,2,2,1]
Output: [0,4,1,3,2]

Example 2:
Input: nums = [1,2,3,4,0], index = [0,1,2,3,0]
Output: [0,1,2,3,4]


*/
class OrderedCreateArr{
    // O(n^2) solution but works because index <= 100
    public int[] createTargetArray(int[] nums, int[] index) {
        ArrayList<Integer> result = new ArrayList<>();
        for(int i = 0; i < index.length; i++) {
            result.add(index[i],nums[i]);
        }
        int[] arr = new int[nums.length];
        for(int i = 0; i < nums.length; i++) {
            arr[i] = result.get(i);
        }
        return arr;
    }
    //O(nlogn) solution (merge sort) 
    // https://leetcode.com/problems/create-target-array-in-the-given-order/discuss/695423/O(NLogN)-Java-Solution-using-Merge-Sort-with-Pen-Paper-Explanation 
    /* 
    public int[] createTargetArray(int[] nums, int[] index) {
        Duo[] duoArr = new Duo[index.length];
        for(int i = 0; i < index.length; i++) {
            duoArr[i] = new Duo[index[i],i];
        }
        mergeSort(duoArr,0,num.length-1);
        int result[] = new result[nums.length];
        for(int i = 0; i < result.length; i++) {
            result[i] = nums[duoArr[i].value];
        }
    }

    public void mergeSort(Duo arr[], int start, int end) {
        if (start > end) {
            return;
        }
        int mid = (start + end)/2;
        mergeSort(arr,start,mid);
        mergeSort(arr,mid,end);
        merge(arr,start,mid,end);
    }

    public void merge(Duo arr[],int start, int end) {
        int left = low , right = mid + 1, index = low;
        Duo temp[] = new Duo[arr.length]; 
        while (left <= mid && right <= end) {
            if(arr[left].index 
        }
    }
    */
}

class Duo {
    public int index;
    public int value; 

    public Duo(int index, int value) {
        this.index = index;
        this.value = value; 
    }
}
