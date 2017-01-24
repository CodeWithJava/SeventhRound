public class Solution
{
	public TreeNode upsideDownBinaryTree(TreeNode root)
	{
		if(root == null)
			return root;

		TreeNode p = root;

		while(p.left != null)
			p = p.left;

		rotate(root);

		return p;
	}

	private void rotate(TreeNode node)
	{
		if(node.left != null)
		{
			rotate(node.left);

			node.left.left = node.right;
			node.left.right = node;

			node.left = null;
			node.right = null;
		}
	}
}