public class Solution
{
	public int countRangeSum(int [] nums, int lower, int upper)
	{
		if(nums == null || nums.length == 0)
			return 0;

		int result = 0;

		Set<Long> set = new HashSet<>();
		long sum = 0;

		for(int x: nums)
		{
			sum += x;
			set.add(sum);
		}

		Long [] sums = set.toArray(new Long [0]);

		Arrays.sort(sums);

		SegmentTreeNode root = buildSegmentTree(sums, 0, sums.length - 1);

		for(int i = nums.length - 1;i >= 0;i--)
		{
			updateSegmentTree(root, sum);
			sum -= nums[i];
			result += getCount(root , lower + sum, upper + sum);
		}

		return result;
	}

	private SegmentTreeNode buildSegmentTree(Long [] sums, int l, int r)
	{
		if(l > r)
			return null;

		SegmentTreeNode root = new SegmentTreeNode(sums[l], sums[r]);

		if(l == r)
			return root;

		int m = l + (r - l) / 2;

		root.left = buildSegmentTree(sums, l, m);
		root.right = buildSegmentTree(sums, m + 1, r);

		return root;
	}

	private void updateSegmentTree(SegmentTreeNode node, Long val)
	{
		if(node == null)
			return;
		else
		{
			if(node.min <= val && val <= node.max)
			{
				node.count++;
				updateSegmentTree(node.left, val);
				updateSegmentTree(node.right, val);
			}
		}
	}

	private int getCount(SegmentTreeNode node, long min, long max)
	{
		if(node == null)
			return 0;

		if(node.max < min || max < node.min)
			return 0;

		if(min <= node.min && node.max <= max)
			return node.count;

		return getCount(node.left, min, max) + getCount(node.right, min, max);
	}
}
class SegmentTreeNode
{
	SegmentTreeNode left;
	SegmentTreeNode right;

	int count;
	long min;
	long max;

	SegmentTreeNode(long min, long max)
	{
		this.min = min;
		this.max = max;
	}
}