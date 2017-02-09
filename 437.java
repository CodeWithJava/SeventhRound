public class Solution
{
	int count = 0;

	public int pathSum(TreeNode root, int sum)
	{
		if(root != null)
		{
			traversal(root, sum);
			pathSum(root.left, sum);
			pathSum(root.right, sum);
		}

		return count;
	}

	private void traversal(TreeNode node, int sum)
	{
		if(node != null)
		{
			if(node.val == sum)
				count++;

			traversal(node.left, sum - node.val);
			traversal(node.right, sum - node.val);
		}
	}
}