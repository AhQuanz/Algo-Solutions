/*
https://leetcode-cn.com/problems/nGK0Fy/
Given that A --> x = 2 * x + y and B --> y = 2 * y + x 
Calculate x + y after doing the operations in S. 

S will only contain A or B 
Input : s = "AB"
Answer : 4

*/
class CalAB {
    public int calculate(String s) {
        //Idea -> Every A / B will cause A + B to multiple by 2 
        /* 
            x = 2 * x + y
            y = 2 * y + x 
            A
            x + y = (2 * x + y) + y = 2*x + 2y 
            
            AB
            x + y = 2 * y + (2 * x + y) + (2 * x + y) = 4 * x + 4 * y 
            
            AA 
            x + y = (2 * (2 * x + y) + y) + y = 4 * x + 4 * y 

        */
        return 1 << s.length();
        
        // Solution 2 : Brute force 
        /*
            int y = 0, x = 1;
            for(int i = 0; i < s.length(); i++) {
                if(s.charAt(i) == 'A') {
                    x = 2 * x + y; 
                } else {
                    y = 2 * y + x; 
                }
            }
        */
    }
}
