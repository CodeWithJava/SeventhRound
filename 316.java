public class Solution
{
	public String removeDuplicateLetters(String s)
	{
		if(s == null || s.length() == 0)
			return s;

		int [] duplicates = new int [26];

		for(char c: s.toCharArray())
			duplicates[c - 'a']++;

		boolean [] exist = new boolean [26];

		Stack<Character> stack = new Stack<>();

		for(char c: s.toCharArray())
		{
			int idx = c - 'a';

			duplicates[idx]--;

			if(exist[idx])
				continue;

			while(!stack.isEmpty() && c < stack.peek() && duplicates[stack.peek() - 'a'] > 0)
				exist[stack.pop() - 'a'] = false;

			stack.push(c);
			exist[idx] = true;
		}

		StringBuilder sb = new StringBuilder();

		while(!stack.isEmpty())
			sb.insert(0, stack.pop());

		return sb.toString();
	}
}