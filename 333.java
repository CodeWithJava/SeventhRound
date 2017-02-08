public class Solution
{
	int [] result;

	public int largestBSTSubtree(TreeNode root)
	{
		if(root == null)
			return 0;

		result = new int [1];

		traversal(root);

		return result[0];
	}

	private void traversal(TreeNode node)
	{
		if(node == null)
			return;

		int numCount = count(node, Integer.MIN_VALUE, Integer.MAX_VALUE);

		if(numCount != -1)
		{
			result[0] = Math.max(result[0], numCount);
			return;
		}

		traversal(node.left);
		traversal(node.right);
	}

	private int count(TreeNode node, int l, int r)
	{
		if(node == null)
			return 0;

		if(node.val <= l || node.val >= r)
			return -1;

		int left = count(node.left, l, node.val);

		if(left == -1)
			return -1;

		int right = count(node.right, node.val, r);

		if(right == -1)
			return -1;

		return left + right + 1;
	}
}