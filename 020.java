public class Solution
{
	Map<Character, Character> map;
	Stack<Character> stack;

	public boolean isValid(String s)
	{
		if(s == null || s.length() == 0)
			return false;

		map = new HashMap<>();
		map.put('(', ')');
		map.put('[', ']');
		map.put('{', '}');

		stack = new Stack<>();

		for(char x: s.toCharArray())
		{
			if(map.containsKey(x))
				stack.push(x);
			else if(map.containsValue(x))
			{
				if(!stack.isEmpty() && map.get(stack.peek()) == x)
					stack.pop();
				else
					return false;
			}
		}

		return stack.isEmpty();
	}
}