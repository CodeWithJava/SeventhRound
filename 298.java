public class Solution
{
	public int longestConsecutive(TreeNode root)
	{
		if(root == null)
			return 0;

		return traversal(root, root.val - 1, 0);
	}

	private int traversal(TreeNode node, int prev, int length)
	{
		if(node == null)
			return length;

		int currLength = node.val == prev + 1 ? length + 1:1;

		return Math.max(currLength, Math.max(traversal(node.left, node.val, currLength), traversal(node.right, node.val, currLength)));
	}
}