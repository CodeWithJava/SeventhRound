class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Set<TreeNode> exist = new HashSet<>();
        TreeNode node = lowestCommonAncestor(root, p, q, exist);
        return exist.size() == 2 ? node:null;
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q, Set<TreeNode> exist) {
        if (root == null) {
            return root;
        }

        TreeNode l = lowestCommonAncestor(root.left, p, q, exist);
        TreeNode r = lowestCommonAncestor(root.right, p, q, exist);

        if (root == p || root == q) {
            exist.add(root);
            return root;
        }

        if (l != null && r != null) {
            return root;
        }

        return l != null ? l:r;
    }
}
