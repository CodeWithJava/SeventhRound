public class Solution
{
	public List<List<Integer>> generate(int numRows)
	{
		List<List<Integer>> result = new ArrayList<>();

		if(numRows < 1)
			return result;

		List<Integer> prev = new ArrayList<>();
		prev.add(1);
		result.add(new ArrayList<>(prev));

		for(int i = 1;i < numRows;i++)
		{
			List<Integer> curr = new ArrayList<>();

			curr.add(1);

			for(int j = 1;j < prev.size();j++)
				curr.add(prev.get(j - 1) + prev.get(j));

			curr.add(1);

			result.add(new ArrayList<>(curr));

			prev = curr;
		}

		return result;
	}
}