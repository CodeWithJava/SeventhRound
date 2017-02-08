public class Solution
{
	public List<List<Integer>> palindromePairs(String [] words)
	{
		List<List<Integer>> result = new ArrayList<>();

		if(words == null || words.length == 0)
			return result;

		Map<String, Integer> map = new HashMap<>();

		for(int i = 0;i < words.length;i++)
			map.put(words[i], i);

		for(int i = 0;i < words.length;i++)
		{
			String s = words[i];

			if(isPalindrome(s))
			{
				if(map.containsKey(""))
				{
					if(map.get("") != i)
					{
						List<Integer> t = new ArrayList<>();
						t.add(i);
						t.add(map.get(""));
						result.add(new ArrayList<>(t));

						t = new ArrayList<>();
						t.add(map.get(""));
						t.add(i);
						result.add(new ArrayList<>(t));
					}
				}
			}

			String reverse = new StringBuilder(s).reverse().toString();

			if(map.containsKey(reverse))
			{
				if(map.get(reverse) != i)
				{
					List<Integer> t = new ArrayList<>();
					t.add(i);
					t.add(map.get(reverse));
					result.add(new ArrayList<>(t));
				}
			}

			for(int k = 1;k < s.length();k++)
			{
				String l = s.substring(0, k);
				String r = s.substring(k);

				if(isPalindrome(l))
				{
					String reverseR = new StringBuilder(r).reverse().toString();

					if(map.containsKey(reverseR))
					{
						if(map.get(reverseR) != i)
						{
							List<Integer> t = new ArrayList<>();
							t.add(map.get(reverseR));
							t.add(i);
							result.add(new ArrayList<>(t));
						}
					}
				}

				if(isPalindrome(r))
				{
					String reverseL = new StringBuilder(l).reverse().toString();

					if(map.containsKey(reverseL))
					{
						if(map.get(reverseL) != i)
						{
							List<Integer> t = new ArrayList<>();
							t.add(i);
							t.add(map.get(reverseL));
							result.add(new ArrayList<>(t));
						}
					}
				}
			}
		}

		return result;
	}

	private boolean isPalindrome(String s)
	{
		int l = 0;
		int r = s.length() - 1;

		while(l < r)
		{
			if(s.charAt(l) != s.charAt(r))
				return false;

			l++;
			r--;
		}

		return true;
	}
}