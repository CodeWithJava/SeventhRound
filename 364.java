public class Solution
{
	public int depthSumInverse(List<NestedInteger> nestedList)
	{
		if(nestedList == null || nestedList.size() == 0)
			return 0;

		int unweighted = 0;
		int weighted = 0;

		while(!nestedList.isEmpty())
		{
			List<NestedInteger> nextLevel = new ArrayList<>();

			for(NestedInteger ni: nestedList)
			{
				if(ni.isInteger())
					unweighted += ni.getInteger();
				else
					nextLevel.addAll(ni.getList());
			}

			weighted += unweighted;
			nestedList = nextLevel;
		}

		return weighted;
	}
}