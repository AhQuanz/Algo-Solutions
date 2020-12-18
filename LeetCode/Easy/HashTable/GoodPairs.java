/*
 A pair (i,j) is called good if nums[i] == nums[j] and i < j.
 Return the number of good pairs.

 Example 1:
 Input: nums = [1,2,3,1,1,3]
 Output: 4

 Example 2:
 Input: nums = [1,1,1,1]
 Output: 6

 Example 3:
 Input: nums = [1,2,3]
 Output: 0

 */

class GoodPairs {
    public int numIdenticalPairs(int[] nums) {
        HashMap<Integer,ArrayList<Integer>> map = new HashMap<>();
        int count = 0;
        for(int i = 0; i < nums.length; i++) {
            ArrayList<Integer> value = map.get(nums[i]);
            if (value == null) {
                value = new ArrayList<>();
            } else {
                count += value.size();
            }
            value.add(i);
            map.put(nums[i], value);
        }
        return count;

        /*
         * Solution 2
            HashMap<Integer,Integer> map = new HashMap<>();
            int count = 0;
            for(int i = 0; i < nums.length; i++) {
                int value = map.get(nums[i]);
                if (value == null) {
                    value = 1;
                } else {
                    count += value;
                }
                value += 1;
                map.put(nums[i], value);
            }
            return count;
         * 
         */
    }
}
