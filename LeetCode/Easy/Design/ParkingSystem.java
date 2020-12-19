/*

https://leetcode.com/problems/design-parking-system/
Example 1:
Input
["ParkingSystem", "addCar", "addCar", "addCar", "addCar"]
[[1, 1, 0], [1], [2], [3], [1]]

Output
[null, true, true, false, false]
 */
class ParkingSystem {
    private int[] slots = new int[3];
    
    public ParkingSystem(int big, int medium, int small) {
        this.slots[0] = big;
        this.slots[1] = medium;
        this.slots[2] = small;
    }
    
    public boolean addCar(int carType) {
        carType -= 1;
        if (slots[carType] == 0) {
            return false;
        } else {
            slots[carType] -= 1;
            return true;
        }
        /*
         * Solution 2 
         * return slots[carType] --> 0;
         */
    }
}
