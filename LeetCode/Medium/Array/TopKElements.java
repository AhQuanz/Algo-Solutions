/*
  https://leetcode.com/problems/top-k-frequent-elements/description/
  Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.

  Example 1:

  Input: nums = [1,1,1,2,2,3], k = 2
  Output: [1,2]
  Example 2:

  Input: nums = [1], k = 1
  Output: [1]
 */
class TopKElements {
    public int[] topKFrequent(int[] nums, int k) {
       HashMap<Integer,Integer> count = new HashMap<>();
        for (int num : nums) {
            count.put(num , count.getOrDefault(num , 0) + 1);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>(k , (a ,b) -> a[1] - b[1]);
        for(Map.Entry<Integer,Integer> entry : count.entrySet()) {
            pq.add(new int[]{entry.getKey(), entry.getValue()});
            if (pq.size() > k) {
                pq.poll();
            }
        }
        int[] res = new int[k];
        for(int i = 0; i < k; i++) {
            int[] e = pq.poll();
            res[i] = e[0];
        }
        return res;
    }
}