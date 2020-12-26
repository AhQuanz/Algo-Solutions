/*
https://leetcode.com/problems/range-sum-of-bst/
Given the root node of a binary search tree, return the sum of values of all nodes with a value in the range [low, high].

Input: root = [10,5,15,3,7,null,18], low = 7, high = 15
Output: 32

Input: root = [10,5,15,3,7,13,18,1,null,6], low = 6, high = 10
Output: 23

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
class RangeSum {
    public int rangeSumBST(TreeNode root, int low, int high) {
        if(root == null) {
            return 0;
        } else if (root.val <= high && root.val >= low) {
            return root.val + rangeSumBST(root.left,low,high) + rangeSumBST(root.right,low,high);
        }
        return rangeSumBST(root.left,low,high) + rangeSumBST(root.right,low,high);
    }
}
