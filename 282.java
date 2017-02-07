public class Solution
{
	List<String> result;

	public List<String> addOperators(String num, int target)
	{
		result = new ArrayList<>();

		if(num == null || num.length() == 0)
			return result;

		traversal(num, target, "", 0, 0);

		return result;
	}

	private void traversal(String num, int target, String t, long currResult, long prevNum)
	{
		if(num.length() == 0 && currResult == target)
			result.add(t);
		else
		{
			for(int i = 1;i <= num.length();i++)
			{
				String x = num.substring(0, i);

				if(x.length() > 1 && x.charAt(0) == '0')
					return;

				long currNum = Long.valueOf(x);

				if(t.length() != 0)
				{
					traversal(num.substring(i), target, t + "*" + currNum, currResult - prevNum + prevNum * currNum, prevNum * currNum);
					traversal(num.substring(i), target, t + "+" + currNum, currResult + currNum, currNum);
					traversal(num.substring(i), target, t + "-" + currNum, currResult - currNum, -currNum);
				}
				else
					traversal(num.substring(i), target, x, currResult + currNum, currNum);
			}
		}
	}
}