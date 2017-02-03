// Solution One
public class Solution
{
	public int closestValue(TreeNode root, double target)
	{
		if(root == null)
			throw new IllegalArgumentException("Input is invalid");

		TreeNode node = root;
		int result = root.val;

		while(node != null)
		{
			result = Math.abs(node.val - target) > Math.abs(result - target) ? result:node.val;
			node = target < node.val ? node.left:node.right;
		}

		return result;
	}
}

// Solution Two
public class Solution
{
	double min = Double.MAX_VALUE;
	int result = 0;

	public int closestValue(TreeNode root, double target)
	{
		if(root == null)
			throw new IllegalArgumentException("Input is invalid");

		traversal(root, target);

		return result;
	}

	private void traversal(TreeNode node, double target)
	{
		if(node == null)
			return;

		if(Math.abs(node.val - target) < min)
		{
			min = Math.abs(node.val - target);
			result = node.val;
		}

		if(target < node.val)
			traversal(node.left, target);
		else
			traversal(node.right, target);
	}
}