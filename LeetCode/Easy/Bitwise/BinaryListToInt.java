/*
https://leetcode.com/problems/convert-binary-number-in-a-linked-list-to-integer/
Given head which is a reference node to a singly-linked list. 
The value of each node in the linked list is either 0 or 1.
The linked list holds the binary representation of a number.
Return the decimal value of the number in the linked list.

Input: head = [1,0,1]
Output: 5

Input: head = [1,0,0,1,0,0,1,1,1,0,0,0,0,0,0]
Output: 18880
*/
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class BinaryListToInt{
    public int getDecimalValue(ListNode head) {
        int result = head.val;
        head = head.next;
        while(head != null) {
            result <<= 1;
            result |= head.val;
            head = head.next;
        }
        return result;
    }
}
