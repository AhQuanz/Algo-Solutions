//https://leetcode.com/problems/decompress-run-length-encoded-list/
/*
 * We are given a list nums of integers representing a list compressed with run-length encoding.
 * Consider each adjacent pair of elements [freq, val] = [nums[2*i], nums[2*i+1]] (with i >= 0). 
 * For each such pair, there are freq elements with value val concatenated in a sublist. 
 * Concatenate all the sublists from left to right to generate the decompressed list.
 * Return the decompressed list.
 *
 * Example 1:
 * Input: nums = [1,2,3,4]
 * Output: [2,4,4,4]
 *
 * Example 2:
 * Input: nums = [1,1,2,3]
 * Output: [1,3,3]
 *
 */ 
class Decompressed {
    public int[] decompressRLElist(int[] nums) {
        ArrayList<Integer> arrList = new ArrayList<>();
        for(int i = 0; i < nums.length; i+=2) {
            for(int j = 0; j < nums[i]; j++) {
                arrList.add(nums[i + 1]);
            }
        }
        int[] result = new int[arrList.size()];

        for(int i = 0; i < arrList.size(); i++) {
            result[i] = arrList.get(i);
        }
        return result;

      /*
        int num_len = 0;
        for(int i = 0; i < nums.length; i+=2){
            num_len += nums[i];
        }
        int[] result = new int[num_len]; 
        int end_index = 0; 
        for(int i = 0; i < nums.length; i+=2) {
            Arrays.fill(result, end_index, end_index + nums[i], nums[i+1]);
            end_index += nums[i];
        }
        return result; 
      */
    }
}
