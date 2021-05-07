/*
https://leetcode.com/problems/maximum-ice-cream-bars/

It is a sweltering summer day, and a boy wants to buy some ice cream bars.

At the store, there are n ice cream bars. You are given an array costs of length n, where costs[i] is the price of the ith ice cream bar in coins. The boy initially has coins coins to spend, and he wants to buy as many ice cream bars as possible. 

Return the maximum number of ice cream bars the boy can buy with coins coins.

Note: The boy can buy the ice cream bars in any order.

Input: costs = [1,3,2,4,1], coins = 7
Output: 4

Input: costs = [10,6,8,7,7,8], coins = 5
Output: 0

Input: costs = [1,6,3,1,2,5], coins = 20
Output: 6
*/
public class MaxIceCream {
   public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        int num = 0;
        for(int price : costs) {
            if (price <= coins) {
                num++;
                coins -= price;
            }
            if(coins <= 0) {
                break;
            }
        }
        return num;
    } 
}
