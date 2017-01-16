public class Solution
{
	public List<Integer> grayCode(int n)
	{
		List<Integer> result = new ArrayList<>();

		if(n < 0)
			return result;

		if(n == 0)
		{
			result.add(0);
			return result;
		}

		result = grayCode(n - 1);
		int size = result.size();
		int reverse = 1 << (n - 1);

		for(int i = size - 1;i >= 0;i--)
			result.add(reverse + result.get(i));

		return result;
	}
}