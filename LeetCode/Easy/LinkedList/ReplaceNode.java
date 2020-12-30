/*
https://leetcode.com/problems/delete-node-in-a-linked-list/submissions/
Weird Quesiton 
Write a function to delete a node in a singly-linked list. 
You will not be given access to the head of the list, 
instead you will be given access to the node to be deleted directly.
It is guaranteed that the node to be deleted is not a tail node in the list.

Input: head = [4,5,1,9], node = 5
Output: [4,1,9]

Input: head = [4,5,1,9], node = 1
Output: [4,5,9]

Input: head = [1,2,3,4], node = 3
Output: [1,2,4]

Input: head = [0,1], node = 0
Output: [1]

Input: head = [-3,5,-99], node = -3
Output: [5,-99]
*/
class ReplaceNode {
    public void deleteNode(ListNode node) {
        //Solution 1 - Change all nodes 
        ListNode prev = node;
        while(node.next != null) {
            node.val = node.next.val;
            prev = node;
            node = node.next;
        }
        prev.next = null;
        //Solution 2 - Change only 2 nodes 
        /*
        node.val = node.next.val;
        node.next = node.next.next;
        */
    }
}
