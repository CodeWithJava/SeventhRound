public class Solution
{
	public boolean isBalanced(TreeNode root)
	{
		if(root == null)
			return true;

		return getHeight(root) != -1;
	}

	private int getHeight(TreeNode node)
	{
		if(node == null)
			return 0;

		int l = getHeight(node.left);
		int r = getHeight(node.right);

		if(l == -1 || r == -1)
			return -1;

		if(Math.abs(l - r) > 1)
			return -1;

		return Math.max(l, r) + 1;
	}
}