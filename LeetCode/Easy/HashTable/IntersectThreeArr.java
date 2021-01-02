/*
https://leetcode-cn.com/problems/intersection-of-three-sorted-arrays/

Given three integer arrays arr1, arr2 and arr3 sorted in strictly increasing order, return a sorted array of only the integers that appeared in all three arrays.

Input: arr1 = [1,2,3,4,5], arr2 = [1,2,5,7,9], arr3 = [1,3,4,5,8]
Output: [1,5]


*/
class IntersectThreeArr{
    public List<Integer> arraysIntersection(int[] arr1, int[] arr2, int[] arr3) {
        //Idea HashMap for count. 
        List<Integer> res = new ArrayList<>();
        Map<Integer,Integer> map = new HashMap<>();
        for(int num : arr1) {
            map.put(num,1);
        }
        for(int num : arr2) {
            if(map.get(num) != null) {
                map.put(num,map.get(num) + 1);
            }
        } 

        for(int num : arr3) {
            if(map.get(num) != null && map.get(num) + 1 == 3) {
                res.add(num);
            }
        }
        return res; 
    }
    //Solution 2 - Use 2 array intersect (Sort , then binary search) 
    /*
    public List<Integer> arraysIntersection(int[] arr1, int[] arr2, int[] arr3) {
        int[] arr4 = intersect(intersect(arr1,arr2),arr3);
        List<Integer> res = new ArrayList<>();
        for(int num : arr4) {
            res.add(num);
        }
        return res;
    }
    public int[] intersect(int[] nums1, int[] nums2) {
        int[] inter = new int[Math.max(nums1.length,nums2.length)];
        int i = 0, j = 0, c = 0;
        while (i < nums1.length && j < nums2.length) {
            if(nums1[i] == nums2[j]) {
                inter[c++] = nums1[i];
                i++;
                j++;
            } else if (nums1[i] < nums2[j]) {
                i++;
            } else {
                j++;
            }
        }
        int[] res = new int[c];
        for(int x = 0; x < c ; x++) {
            res[x] = inter[x];
        }
        return res;
    }
    */
}
