public class Solution
{
	int max = 0;

	public int diameterOfBinaryTree(TreeNode root)
	{
		traversal(root);

		return max;
	}

	private int traversal(TreeNode node)
	{
		if(node == null)
			return 0;

		int l = traversal(node.left);
		int r = traversal(node.right);

		max = Math.max(max, l + r);

		return Math.max(l, r) + 1;
	}
}