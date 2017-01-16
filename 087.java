public class Solution
{
	public boolean isScramble(String s1, String s2)
	{
		if((s1 == null || s1.length() == 0) && (s2 == null || s2.length() == 0) || s1.equals(s2))
			return true;

		if((s1 == null || s1.length() == 0) || (s2 == null || s2.length() == 0))
			return false;

		if(s1.length() != s2.length())
			return false;

		char [] x = s1.toCharArray();
		char [] y = s2.toCharArray();

		Arrays.sort(x);
		Arrays.sort(y);

		if(! new String(x).equals(new String(y)))
			return false;

		int l = s1.length();

		for(int i = 1;i < l;i++)
		{
			String s11 = s1.substring(0, i);
			String s12 = s1.substring(i, l);
			String s21 = s2.substring(0, i);
			String s22 = s2.substring(i, l);
			String s23 = s2.substring(0, l - i);
			String s24 = s2.substring(l - i, l);

			if(isScramble(s11, s21) && isScramble(s12, s22))
				return true;

			if(isScramble(s11, s24) && isScramble(s12, s23))
				return true;
		}

		return false;
	}
}