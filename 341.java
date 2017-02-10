public class NestedIterator implements Iterator<Integer>
{
	Stack<NestedInteger> stack = new Stack<>();

	NestedIterator(List<NestedInteger> nestedList)
	{
		if(nestedList == null || nestedList.size() == 0)
			return;

		for(int i = nestedList.size() - 1;i >= 0;i--)
			stack.push(nestedList.get(i));
	}

	@Override
	public Integer next()
	{
		return stack.pop().getInteger();
	}

	@Override
	public boolean hasNext()
	{
		while(!stack.isEmpty())
		{
			NestedInteger x = stack.peek();

			if(x.isInteger())
				return true;
			else
			{
				stack.pop();

				for(int i = x.getList().size() - 1;i >= 0;i--)
					stack.push(x.getList().get(i));
			}
		}

		return false;
	}
}