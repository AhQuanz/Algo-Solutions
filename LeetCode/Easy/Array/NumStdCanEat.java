/*
https://leetcode.com/problems/number-of-students-unable-to-eat-lunch/
The school cafeteria offers circular and square sandwiches at lunch break, referred to by numbers 0 and 1 respectively. 
All students stand in a queue. Each student either prefers square or circular sandwiches.
The number of sandwiches in the cafeteria is equal to the number of students. 
The sandwiches are placed in a stack. At each step:
If the student at the front of the queue prefers the sandwich on the top of the stack, 
they will take it and leave the queue.
Otherwise, they will leave it and go to the queue's end.
This continues until none of the queue students want to take the top sandwich and are thus unable to eat.

You are given two integer arrays students and sandwiches where sandwiches[i] is the type of the ith sandwich in the stack (i = 0 is the top of the stack) 
and students[j] is the preference of the jth student in the initial queue (j = 0 is the front of the queue). 
Return the number of students that are unable to eat.

Input: students = [1,1,0,0], sandwiches = [0,1,0,1]
Output: 0 

Input: students = [1,1,1,0,0,1], sandwiches = [1,0,0,0,1,1]
Output: 3
*/
class NumStdCanEat {
    public int countStudents(int[] students, int[] sandwiches) {
        // Idea is to count the number of sandwiches wanted 
        int sq = 0;
        for(int s : students) {
            if (s == 1) {
                sq++;
            }
        }
        int cir = students.length - sq;
        // Then process the number of sandwiches avaliable
        for(int s : sandwiches) {
            if(s == 1) {
                sq--;
            } else {
                cir--;
            }

            if(sq < 0 || cir < 0) {
                return sq + 1 + cir;
            }
        }
        return 0;
    }
}
