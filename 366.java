public class Solution
{
	public List<List<Integer>> findLeaves(TreeNode root)
	{
		List<List<Integer>> result = new ArrayList<>();

		if(root == null)
			return result;

		traversal(root ,result);

		return result;
	}

	private int traversal(TreeNode node, List<List<Integer>> result)
	{
		if(node == null)
			return -1;

		int l = traversal(node.left, result);
		int r = traversal(node.right, result);

		int height = Math.max(l, r) + 1;

		if(result.size() == height)
			result.add(new ArrayList<>());

		result.get(height).add(node.val);

		return height;
	}
}