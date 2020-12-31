//https://leetcode.com/problems/invert-binary-tree/
// [1,2] 
// [4,2,7,1,3,6,9]
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
class InvertBTree {
    public TreeNode invertTree(TreeNode root) {
        //Inital Solution 
        if(root == null) {
            return null;
        } else if (root.left != null && root.right != null) {
            TreeNode left = invertTree(root.right);
            TreeNode right = invertTree(root.left);
            root.left = left;
            root.right = right; 
        } else if (root.left == null) {
            root.left = invertTree(root.right);
            root.right = null;
        } else if (root.right == null) {
            root.right = invertTree(root.left);
            root.left = null;
        }
        return root;
        //New solution 
        /*
        
        if(root == null) {
            return null;
        } 
        TreeNode left = invertTree(root.right);
        TreeNode right = invertTree(root.left);
        root.left = left;
        root.right = right;
        return root
        
        */
    }
}
