/*
https://leetcode.com/problems/merge-two-binary-trees/
Given two binary trees and imagine that when you put one of them to cover the other, 
some nodes of the two trees are overlapped while the others are not.
You need to merge them into a new binary tree. 
The merge rule is that if two nodes overlap, then sum node values up as the new value of the merged node. Otherwise, the NOT null node will be used as the node of new tree.

Input:
[1,3,2,5]
[2,1,3,null,4,null,7]

Output:
[3,4,5,5,4,null,7]
*/
class MergeTwoBTrees{
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if(t1 == null && t2 == null) {
            return null;
        } else if(t1 == null) {
            return t2; 
        } else if(t2 == null) {
            return t1;
        } 

        TreeNode res = new TreeNode(t2.val + t1.val);
        res.left = mergeTrees(t1 == null ? null : t1.left ,t2 == null ? null : t2.left);
        res.right = mergeTrees(t1 == null ? null : t1.right,t2 == null ? null : t2.right);
        return res;
    }
}
