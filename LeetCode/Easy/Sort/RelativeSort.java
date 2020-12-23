/*
https://leetcode.com/problems/relative-sort-array

Given two arrays arr1 and arr2, the elements of arr2 are distinct, and all elements in arr2 are also in arr1.
Sort the elements of arr1 such that the relative ordering of items in arr1 are the same as in arr2.  
Elements that don't appear in arr2 should be placed at the end of arr1 in ascending order.

Input: arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
Output: [2,2,2,1,4,3,3,9,6,7,19]

[2,21,43,38,0,42,33,7,24,13,12,27,12,24,5,23,29,48,30,31]
[2,42,38,0,43,21]
Output: [2,42,38,0,43,21,5,7,12,12,13,23,24,24,27,29,30,31,33,48]

(/
class RelativeSort{
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        //SOlution 1 (1 HashSet , 1 HashMap , 1 PQ) O(nLogN) 
        int[] arr3 = new int[arr1.length];
        HashSet<Integer> map = new HashSet<>();
        for(int i = 0; i < arr2.length; i++) {
            map.add(arr2[i]);
        }
        PriorityQueue <Integer> PQ = new PriorityQueue<>();
        HashMap<Integer,Integer> map2 = new HashMap<>();
        for(int i = 0; i < arr1.length; i++) {
            if (map.contains(arr1[i])) {
                Integer num = map2.get(arr1[i]);
                if(num != null) {
                    map2.put(arr1[i],num+1);
                } else {
                    map2.put(arr1[i],1);
                }
            } else {
                PQ.add(arr1[i]);
            }
        }
        int count = 0;
        for(int i = 0; i < arr2.length; i++){
            int num = map2.get(arr2[i]);
            Arrays.fill(arr3,count,count+num,arr2[i]);
            count += num;
        }
        for(int i = count; i < arr1.length; i++) {
            int num = PQ.poll();
            arr3[i] = num;
        }
        return arr3;

        //Solution 2 (Counting Sort) (1 Array without sort)  
        /*
        int max = arr1[0];
        for(int i : arr1) {
            if (i > max) {
                max = i;
            }
        }
        int[] freq = new int[max + 1];
        for (int i : arr1) {
            freq[i] += 1;
        }
        
        int count = 0;
        for (int i : arr2) {
            Arrays.fill(arr1,count, freq[i] + count, i);
            count += freq[i];
            freq[i] = 0;
        }
        for (int i = 0; i < freq.length; i++) {
            if(freq[i] != 0) {
                arr1[count] = i;
                count++;
            }
        }
        return result;
        */
    }
}
