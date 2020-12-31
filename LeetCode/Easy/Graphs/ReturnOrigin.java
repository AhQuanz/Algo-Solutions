/*
More like a graph question rather than a String (Find out if [x,y] is reachable by this steps)
https://leetcode.com/problems/robot-return-to-origin/

There is a robot starting at position (0, 0), the origin, on a 2D plane. 
Given a sequence of its moves, judge if this robot ends up at (0, 0) after it completes its moves.
The move sequence is represented by a string, and the character moves[i] represents its ith move.
Valid moves are R (right), L (left), U (up), and D (down). 
If the robot returns to the origin after it finishes all of its moves, return true. Otherwise, return false.
Note: The way that the robot is "facing" is irrelevant. "R" will always make the robot move to the right once, "L" will always make it move left, etc. Also, assume that the magnitude of the robot's movement is the same for each move.

Input: moves = "UD"
Output: true

Input: moves = "LL"
Output: false

Input: moves = "RRDD"
Output: false

Input: moves = "LDRRLRUULR"
Output: false
*/
class ReturnOrigin {
    public boolean judgeCircle(String moves) {
        //Solution 1 - HashMap
        Map<Character,int[]> direction = new HashMap<>();
        direction.put('U', new int[] {1,0});
        direction.put('D', new int[] {-1,0});
        direction.put('L', new int[] {0,1});
        direction.put('R', new int[] {0,-1});
        int x = 0, y = 0;
        for(int i = 0; i < moves.length(); i++) {
            int[] move = direction.get(moves.charAt(i));
            x += move[0];
            y += move[1];
        }
        return x == 0 && y == 0;
        /*
        //Solution 2 - Counting 
        int x = 0, y = 0;
        for(int i = 0; i < moves.length(); i++) {
            switch (moves.charAt(i)) {
                case 'U':
                    x++;
                    break;
                case 'D':
                    x--;
                    break;
                case 'L':
                    y++;
                    break;
                case 'R':
                    y--;
                    break;
            }
        }
        return x == 0 && y == 0;
        */

        /*
        //Solution 3 is to use an int[].
        */
    } 
}
