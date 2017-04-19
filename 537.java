public class Solution
{
	public String complexNumberMultiply(String a, String b)
	{
		if(a == null || a.length() == 0 || b == null || b.length() == 0)
			return "";

		int [] x = getValue(a);
		int [] y = getValue(b);

		int real = x[0] * y[0] - x[1] * y[1];
		int img = x[0] * y[1] + x[1] * y[0];

		return real + "+" + img + "i";
	}

	private int [] getValue(String s)
	{
		String [] strs = s.split("\\+");
		return new int [] {Integer.valueOf(strs[0]), Integer.valueOf(strs[1].substring(0, strs[1].length() - 1))};
	}
}