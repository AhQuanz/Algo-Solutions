/*
 * https://leetcode.com/problems/mean-of-array-after-removing-some-elements/
 * Given an integer array arr, return the mean of the remaining integers 
 * after removing the smallest 5% and the largest 5% of the elements.
 *
 * Input: arr = [1,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,3]
 * Output: 2.00000
 *
 * Input: arr = [6,2,7,5,1,2,0,3,10,2,5,0,5,5,0,8,7,6,8,0]
 * Output: 4.00000
 *
 * Input: arr = [6,0,7,0,7,5,7,8,3,4,0,7,8,1,6,8,1,1,2,4,8,1,9,5,4,3,8,5,10,8,6,6,1,0,6,10,8,2,3,4]
 * Output: 4.77778
 *
 * Input: arr = [9,7,8,7,7,8,4,4,6,8,8,7,6,8,8,9,2,6,0,0,1,10,8,6,3,3,5,1,10,9,0,7,10,0,10,4,1,10,6,9,3,6,0,0,2,7,0,6,7,2,9,7,7,3,0,1,6,1,10,3]
 * Output: 5.27778
 *
 * Input: arr = [4,8,4,10,0,7,1,3,7,8,8,3,4,1,6,2,1,1,8,0,9,8,0,3,9,10,3,10,1,10,7,3,2,1,4,9,10,7,6,4,0,8,5,1,2,1,6,2,5,0,7,10,9,10,3,7,10,5,8,5,7,6,7,6,10,9,5,10,5,5,7,2,10,7,7,8,2,0,1,1]
 * Output: 5.29167
 */
class MeanAftRemove{
    public double trimMean(int[] arr) {
        // Solution 1 - O(nlogn) 
        Arrays.sort(arr);
        int f_percent = (int) (arr.length/100.0 * 5);
        int sum = 0;
        double count = 0;
        for(int i = f_percent; i < arr.length - f_percent; i++) {
            sum += arr[i];
            count++;
        }
        return sum / count;

        //Solution 2 - O(n) (Quick Select) 
        //https://leetcode.com/problems/mean-of-array-after-removing-some-elements/discuss/899277/Java-QuickSelect-O(n)
        //How we can partition our array in the way that left part of the array will be always smaller than right - Quick Select.
        /*
        public double trimMean(int[] arr) {
            int trim = arr.length / 20;

            qselectmin(arr, 0, arr.length - 1, trim);
            qselectmin(arr, trim, arr.length - 1, arr.length - 2 * trim);

            int sum = 0;
            for (int i = trim, l = arr.length - trim; i < l; i++)
                sum += arr[i];
            return (double) sum / (arr.length - 2 * trim);
        }

        Random rnd = new Random();

        public void qselectmin(int[] a, int from, int to, int k) {
            if (from == to)
                return;
            int pi = partition(a, from, to);
            int total = pi - from + 1;
            if (total == k)
                return;
            if (total < k)
                qselectmin(a, pi + 1, to, k - total);
            else
                qselectmin(a, from, pi - 1, k);
        }

        private int partition(int[] a, int l, int r) {
            int p = l + rnd.nextInt(r - l);
            swap(a, p, r);
            p = r;
            int pivot = a[p];

            int i = l;

            for (int j = l; j < r; j++) {
                if (a[j] <= pivot)
                    swap(a, i++, j);
            }
            swap(a, i, p);

            return i;
        }

        private void swap(int[] a, int l, int r) {
            int t = a[l];
            a[l] = a[r];
            a[r] = t;
        } 
        */
    }
}
