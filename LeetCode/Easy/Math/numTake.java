/*
https://leetcode-cn.com/problems/na-ying-bi/
At every table in coins , you can only take up to 2 coins 
return the number of times required to finish taking all the coins from all tables 

input : [4,2,1]
output : 4

input: 2,3,10]
output: 8

*/
class numTake {
    public int minCount(int[] coins) {
        int num = 0;
        for(int coin : coins) {
            num += (coin + 1) >> 1;
        }
        return num;
    }
}
