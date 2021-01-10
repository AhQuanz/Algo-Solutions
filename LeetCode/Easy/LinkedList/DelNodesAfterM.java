/*
https://leetcode-cn.com/problems/delete-n-nodes-after-m-nodes-of-a-linked-list/
Start from head of list , then traverse M nodes 
then delete N nodes before restarting

Input: head = [1,2,3,4,5,6,7,8,9,10,11,12,13], m = 2, n = 3
Output: [1,2,6,7,11,12]

Input: head = [1,2,3,4,5,6,7,8,9,10,11], m = 1, n = 3
Output: [1,5,9]

Input: head = [1,2,3,4,5,6,7,8,9,10,11], m = 3, n = 1
Output: [1,2,3,5,6,7,9,10,11]

Input: head = [9,3,7,7,9,10,8,2], m = 1, n = 2
Output: [9,7,8]
*/
class DelNodesAfterM {
    public ListNode deleteNodes(ListNode head, int m, int n) {
        ListNode last = head; 
        while(last != null) {
            last = getNode(last,m-1);
            ListNode next = getNode(last,n + 1);
            if(last != null) {
                last.next = next;
                last = last.next;
            }
        }
        return head; 
    }
    public ListNode getNode(ListNode now, int n) {
        while(now != null && n > 0) {
            now = now.next;
            n--;
        }
        return now;
    }
}
