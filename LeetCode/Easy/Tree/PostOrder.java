/*
https://leetcode.com/problems/n-ary-tree-postorder-traversal/
Given an n-ary tree, return the postorder traversal of its nodes' values.
Nary-Tree input serialization is represented in their level order traversal
each group of children is separated by the null value (See examples).

Input: root = [1,null,3,2,4,null,5,6]
Output: [5,6,3,2,4,1]

Input: root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]
Output: [2,6,14,11,7,3,12,8,4,13,9,10,5,1]"+gP
*/
class PostOrder {
    public List<Integer> postorder(Node root) {
        //Instead of recursion , use a stack to do the recursion.
        //Then instead of 2nd stack use a LinkedList and add to the head 
        LinkedList<Integer> res = new LinkedList<>();
        if (root == null) {
            return res; 
        }
        Stack<Node> s = new Stack<>();
        s.push(root);
        while(!s.isEmpty()) {
            root = s.pop();
            res.addFirst(root.val);
            for(Node child : root.children) {
                s.push(child);
            }
        }
        return res;
    }
}
