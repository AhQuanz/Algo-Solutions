/*
https://leetcode-cn.com/problems/intersection-of-two-arrays/
Given 2 arrays , find the intersection of the two. 

Input: nums1 = [1,2,2,1], nums2 = [2,2]
Output: [2]

Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
Output: [9,4]

Input: num1 = [1,2,2,1], nums2 = [2,2]
Output: [2,2]
*/
class IntersectTwoArr{
    public int[] intersection(int[] nums1, int[] nums2) {
        //Solution 1 - HashMap O(N + M) 
        List<Integer> res = new ArrayList<>();
        Map<Integer,Integer> map = new HashMap<>();
        for(int num : nums1) {
            if(map.get(num) == null) {
                map.put(num, 1);
            } else {
                map.put(num, map.get(num) + 1);
            }
        }
        for(int num: nums2) {
            if(map.get(num) != null) {
                res.add(num);
                map.remove(num);
            }
        }
        int[] arr = new int[res.size()]; 
        int i = 0;
        for(int num : res) {
            arr[i] = num;
            i++;
        }
        return arr;
        //Solution 2 - Sort 2 Array then do a double pointer 
        // O(N log N + M Log M) 
        /*
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        Set<Integer> s = new HashSet<>();
        int i = 0, j = 0;
        while (i < nums1.length && j < nums2.length) {
            if(nums1[i] == nums2[j]) {
                s.add(nums1[i]);
                i++;
                j++;
            } else if (nums1[i] < nums2[j]) {
                i++;
            } else {
                j++;
            }
        }

        int[] res = new int[s.size()];
        int count = 0;
        for(int num : s) {
            res[count++] = num;
        }
        return res;
        */

        //Solution 3 - modify solution 2 with int array to replace Set 
        /*
        public int[] intersection(int[] nums1, int[] nums2) {
            Arrays.sort(nums1);
            Arrays.sort(nums2);
            int[] inter = new int[Math.max(nums1.length,nums2.length)];
            int i = 0, j = 0, c = 0;
            while (i < nums1.length && j < nums2.length) {
                if(nums1[i] == nums2[j]) {
                    if(c == 0 || inter[c-1] != nums1[i]) {
                        inter[c++] = nums1[i];
                    }
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
}
