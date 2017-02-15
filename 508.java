public class Solution
{
	Map<Integer, Integer> map;
	int max;

	public int [] findFrequentTreeSum(TreeNode root)
	{
		if(root == null)
			return new int [0];

		map = new HashMap<>();
		max = 0;

		traversal(root);

		List<Integer> t = new ArrayList<>();

		for(int x: map.keySet())
			if(map.get(x) == max)
				t.add(x);

		int [] result = new int [t.size()];

		for(int i = 0;i < t.size();i++)
			result[i] = t.get(i);

		return result;
	}

	private int traversal(TreeNode node)
	{
		if(node == null)
			return 0;

		int l = traversal(node.left);
		int r = traversal(node.right);

		int sum = l + node.val + r;
		int count = map.getOrDefault(sum, 0) + 1;

		map.put(sum, count);

		max = Math.max(max, count);

		return sum;
	}
}