/*
  Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.
  You must write an algorithm that runs in O(n) time.

  Input: nums = [100,4,200,1,3,2]
  Output: 4
  Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.

  Input: nums = [0,3,7,2,5,8,4,6,0,1]
  Output: 9
  
*/
class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> s = new HashSet<>();
        for (int num : nums) { 
            s.add(num);
        }
        
        int res = 0;
        for(int i = 0; i < nums.length; i++) {
            int steak = 0;
            if(!s.contains(nums[i] - 1)) {
                while(s.contains(nums[i] + steak)) {
                    steak += 1;
                }
            }
            if(res < steak) {
                res = steak;
            }
        } 
        return res;       
    }
}