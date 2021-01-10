/*
https://leetcode.com/problems/search-in-a-binary-search-tree/

Given the root node of a binary search tree (BST) and a value. 
You need to find the node in the BST that the node's value equals the given value. 
Return the subtree rooted with that node. If such node doesn't exist, you should return NULL.

input : BST : [4,2,7,1,3] val : 2
output : [2,1,3] 

*/
class BstSearch {
    public TreeNode searchBST(TreeNode root, int val) {
        if(root == null || root.val == val) {
            return root;
        } else if (root.val < val) {
            return searchBST(root.right,val);
        } 
        return searchBST(root.left,val);
    }
}
