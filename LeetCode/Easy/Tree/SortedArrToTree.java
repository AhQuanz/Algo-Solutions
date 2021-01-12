/*
https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/

Given an array where elements are sorted in ascending order, convert it to a height balanced BST.

For this problem, a height-balanced binary tree is defined as a 
binary tree in which the depth of the two subtrees of every node never differ by more than 1.

Given the sorted array: [-10,-3,0,5,9],

One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST
*/
class SortedArrToTree {
    public TreeNode sortedArrayToBST(int[] nums) {
        return create(nums,0,nums.length-1);
    }
    public TreeNode create(int[] nums, int s , int e) {
        if (s > e) {
            return null;
        } 
        int mid = (e + s) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = create(nums,s,mid-1);
        root.right = create(nums,mid+1,e);
        return root;
    }
}
