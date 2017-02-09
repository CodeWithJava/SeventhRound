// Solution One
public class Solution
{
	public boolean isValidSerialization(String preorder)
	{
		if(preorder == null || preorder.length() == 0)
			return false;

		String [] elements = preorder.split("\\,");

		Stack<String> stack = new Stack<>();

		for(String x: elements)
		{
			if(x.equals("#"))
			{
				while(!stack.isEmpty() && stack.peek().equals("#"))
				{
					stack.pop();

					if(stack.isEmpty())
						return false;

					stack.pop();
				}
			}

			stack.push(x);
		}

		return stack.size() == 1 && stack.peek().equals("#");
	}
}

// Solution Two
public class Solution
{
	public boolean isValidSerialization(String preorder)
	{
		if(preorder == null || preorder.length() == 0)
			return false;

		String [] elements = preorder.split("\\,");

		int difference = 1;

		for(String x: elements)
		{
			if(--difference < 0)
				return false;

			if(!x.equals("#"))
				difference += 2;
		}

		return difference == 0;
	}
}