public class Solution
{
	public int maxPathSum(TreeNode root)
	{
		if(root == null)
			return 0;

		int [] result = new int [1];
		result[0] = Integer.MIN_VALUE;

		traversal(root, result);

		return result[0];
	}

	private int traversal(TreeNode node, int [] result)
	{
		if(node == null)
			return 0;

		int l = traversal(node.left, result);
		int r = traversal(node.right, result);

		int current = Math.max(node.val, Math.max(node.val + l, node.val + r));

		result[0] = Math.max(result[0], Math.max(current, l + node.val + r));

		return current;
	}
}