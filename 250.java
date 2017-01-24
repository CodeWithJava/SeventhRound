public class Solution
{
	int count = 0;

	public int countUnivalSubtrees(TreeNode root)
	{
		if(root == null)
			return count;

		traversal(root);

		return count;
	}

	private boolean traversal(TreeNode node)
	{
		if(node == null)
			return true;

		boolean l = traversal(node.left);
		boolean r = traversal(node.right);

		if(l && r && (node.left == null || node.left.val == node.val) && (node.right == null || node.right.val == node.val))
		{
			count++;
			return true;
		}

		return false;
	}
}