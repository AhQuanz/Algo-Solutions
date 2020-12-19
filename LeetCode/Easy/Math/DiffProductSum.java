/*
 * https://leetcode.com/problems/subtract-the-product-and-sum-of-digits-of-an-integer/
 * Given an integer number n, return the difference between the product of its digits and the sum of its digits.
 * Example 1:
 * Input: n = 234
 * Output: 15
 *
 * Example 2:
 * Input: n = 4421
 * Output: 21
 */
class DIffProductSum {
    public int subtractProductAndSum(int n) {
        int product = 1, sum = 0;
        do {
            product *= n % 10;
            sum += n %10;
            n /= 10;
        } while (n != 0);
        return product - sum;
    }
}
