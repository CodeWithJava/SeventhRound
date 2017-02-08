public class Solution
{
	public int depthSum(List<NestedInteger> nestedList)
	{
		if(nestedList == null || nestedList.size() == 0)
			return 0;

		return traversal(nestedList, 1);
	}

	private int traversal(List<NestedInteger> list, int depth)
	{
		int sum = 0;

		for(NestedInteger x: list)
		{
			if(x.isInteger())
				sum += x.getInteger() * depth;
			else
				sum += traversal(x.getList(), depth + 1);
		}

		return sum;
	}
}