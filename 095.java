public class Solution
{
	public List<TreeNode> generateTrees(int n)
	{
		if(n < 0)
			throw new IllegalArgumentException("Input must be non-negative");

		if(n < 1)
			return new ArrayList<>();

		return generateTrees(1, n);
	}

	private List<TreeNode> generateTrees(int l, int r)
	{
		List<TreeNode> list = new ArrayList<>();

		if(l > r)
		{
			list.add(null);
			return list;
		}

		for(int i = l;i <= r;i++)
		{
			List<TreeNode> lefts = generateTrees(l, i - 1);
			List<TreeNode> rights = generateTrees(i + 1, r);

			for(TreeNode left: lefts)
			{
				for(TreeNode right: rights)
				{
					TreeNode node = new TreeNode(i);
					node.left = left;
					node.right = right;

					list.add(node);
				}
			}
		}

		return list;
	}
}