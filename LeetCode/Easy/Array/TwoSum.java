  class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];

        HashMap<Integer,Integer> numberIndex = new HashMap<>();
        for(int i = 0 ; i < nums.length; i++) {
            int num = nums[i];
            if(numberIndex.get(target- num) == null) {
                numberIndex.put(num, i);
            } else {
                res = new int[]{numberIndex.get(target-num) , i};
                break;
            }
        }
        return res;
    }
  }