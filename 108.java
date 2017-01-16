public class Solution
{
	public TreeNode sortedArrayToBST(int [] nums)
	{
		if(nums == null || nums.length == 0)
			return null;

		return build(nums, 0, nums.length - 1);
	}

	private TreeNode build(int [] nums, int l, int r)
	{
		if(l > r)
			return null;

		int m = l + (r - l ) / 2;

		TreeNode node = new TreeNode(nums[m]);
		node.left = build(nums, l, m - 1);
		node.right = build(nums, m + 1, r);

		return node;
	}
}