public class Solution
{
	public int countNodes(TreeNode root)
	{
		if(root == null)
			return 0;

		int l = getL(root);
		int r = getR(root);

		if(l == r)
			return (2 << (l - 1)) - 1;

		return countNodes(root.left) + countNodes(root.right) + 1;
	}

	private int getL(TreeNode node)
	{
		int height = 0;

		while(node != null)
		{
			height++;
			node = node.left;
		}

		return height;
	}

	private int getR(TreeNode node)
	{
		int height = 0;

		while(node != null)
		{
			height++;
			node = node.right;
		}

		return height;
	}
}