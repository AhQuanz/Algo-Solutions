/*
https://leetcode.com/problems/goal-parser-interpretation/
You own a Goal Parser that can interpret a string command. 
The command consists of an alphabet of "G", "()" and/or "(al)" in some order. 
The Goal Parser will interpret "G" as the string "G", "()" as the string "o", and "(al)" as the string "al". 
The interpreted strings are then concatenated in the original order.
Given the string command, return the Goal Parser's interpretation of command.

Example 1:
Input: command = "G()(al)"
Output: "Goal"

Example 2:
Input: command = "G()()()()(al)"
Output: "Gooooal"

Example 3:
Input: command = "(al)G(al)()()G"
Output: "alGalooG"
*/

class GoalParser {
    public String interpret(String command) {
        String result = command.replace("()","o");
        result = result.replace("(al)","al");
        return result;
        /* 
         *  StringBuilder result = new StringBuilder();
            for(int i = 0; i < command.length(); i++) {
                if (command.charAt(i) == '(' && command.charAt(i+1) == ')') {
                    result.append("o");
                    i+=1;
                } else if (command.charAt(i) == '(') {
                    result.append("al");
                    i+=3;
                } else {
                    result.append(command.charAt(i));
                }
            }
            return result.toString();
        */
    }
}
