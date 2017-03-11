// BST Solution
public class Solution
{
	int minDifference = Integer.MAX_VALUE;
	TreeNode prev;

	public int getMinimumDifference(TreeNode root)
	{
		if(root == null)
			return Integer.MAX_VALUE;

		traversal(root);
		return minDifference;
	}

	private void traversal(TreeNode node)
	{
		if(node == null)
			return;

		traversal(node.left);

		if(prev != null)
			minDifference = Math.min(minDifference, node.val - prev.val);
		prev = node;

		traversal(node.right);
	}
}

// BT Solution
public class Solution
{
	Set<Integer> set = new TreeSet<>();
	int minDifference = Integer.MAX_VALUE;

	public int getMinimumDifference(TreeNode root)
	{
		if(root == null)
			return Integer.MAX_VALUE;

		traversal(root);

		return minDifference;
	}

	private void traversal(TreeNode node)
	{
		if(node == null)
			return;

		if(!set.isEmpty())
		{
			if(set.floor(node.val) != null)
				minDifference = Math.min(minDifference, node.val - set.floor(node.val));
			if(set.ceiling(node.val) != null)
				min = Math.min(minDifference, set.ceiling(node.val) - node.val);
		}

		set.add(node.val);

		traversal(node.left);
		traversal(node.right);
	}
}