class LonelyNodes {
    public List<Integer> getLonelyNodes(TreeNode root) {
        if (root.left == null && root.right == null) {
            return new ArrayList<>() ;
        } else {
            return getLonelyNodesRec(root);
        }
    }
    public List<Integer> getLonelyNodesRec(TreeNode root) {
        if(root == null) {
            return null;
        } else {
            List<Integer> res = new ArrayList<>();
            List<Integer> left = getLonelyNodesRec(root.left); 
            List<Integer> right = getLonelyNodesRec(root.right);

            if(root.left == null && root.right != null) {
                res.add(root.right.val);
            } else if (root.left != null && root.right == null) {
                res.add(root.left.val);
            }

            if(left != null) {
                res.addAll(left);
            }

            if(right != null) {
                res.addAll(right);
            }

            return res;
        }
    }
    /*
    Solution 2 
    public List<Integer> getLonelyNodes(TreeNode root) {
        if(root == null || (root.left == null && root.right == null)) {
            return new ArrayList<>();
        } else {
            List<Integer> res = new ArrayList<>();

            if(root.left == null && root.right != null) {
                res.add(root.right.val);
            } else if (root.left != null && root.right == null) {
                res.add(root.left.val);
            }

            List<Integer> left = getLonelyNodes(root.left); 
            List<Integer> right = getLonelyNodes(root.right);
            res.addAll(left);
            res.addAll(right);

            return res;
        }
    }
    */
}
