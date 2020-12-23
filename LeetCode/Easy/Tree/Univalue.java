/*
https://leetcode.com/problems/univalued-binary-tree/
A binary tree is univalued if every node in the tree has the same value.
Return true if and only if the given tree is univalued.

Input: [1,1,1,1,1,null,1]
Output: true

Input: [2,2,2,5,2]
Output: false

*/
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Univalue {
    public boolean isUnivalTree(TreeNode root) {
        return isUnivalTreeRec(root.left, root.val) && isUnivalTreeRec(root.right, root.val);
    }
    public boolean isUnivalTreeRec(TreeNode root , int val){
        if (root == null) {
            return true;
        }
        return val == root.val && isUnivalTreeRec(root.left,root.val) && isUnivalTreeRec(root.right,root.val) ;
    } 
}
