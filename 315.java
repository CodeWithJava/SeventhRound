public class Solution
{
	public List<Integer> countSmaller(int [] nums)
	{
		List<Integer> result = new ArrayList<>();

		if(nums == null || nums.length == 0)
			return result;

		int [] t = nums.clone();
		Arrays.sort(t);

		int [] bit = new int [nums.length + 1];

		for(int x: nums)
			update(bit, Arrays.binarySearch(t, x), 1);

		for(int x: nums)
		{
			int idx = Arrays.binarySearch(t, x);
			update(bit, idx, -1);
			result.add(query(bit, idx - 1));
		}

		return result;
	}

	private void update(int [] bit, int idx, int x)
	{
		for(int i = idx + 1;i < bit.length;i += i & -i)
			bit[i] += x;
	}

	private int query(int [] bit, int idx)
	{
		int sum = 0;

		for(int i = idx + 1;i > 0;i -= i & -i)
			sum += bit[i];

		return sum;
	}
}