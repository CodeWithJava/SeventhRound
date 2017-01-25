public class Solution
{
	public List<String> binaryTreePaths(TreeNode root)
	{
		List<String> result = new ArrayList<>();

		if(root == null)
			return result;

		traversal(root, String.valueOf(root.val), result);

		return result;
	}

	private void traversal(TreeNode node, String t, List<String> result)
	{
		if(node.left == null && node.right == null)
			result.add(t);
		else
		{
			if(node.left != null)
				traversal(node.left, t + "->" + node.left.val, result);

			if(node.right != null)
				traversal(node.right, t + "->" + node.right.val, result);
		}
	}
}