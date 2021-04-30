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
