public class Solution
{
	public String getHint(String secret, String guess)
	{
		if(secret == null || secret.length() == 0 || guess == null || guess.length() == 0 || secret.length() != guess.length())
			throw new IllegalArgumentException("Input is invalid");

		int [] x = new int [10];

		int bull = 0;

		for(int i = 0;i < guess.length();i++)
		{
			if(guess.charAt(i) == secret.charAt(i))
				bull++;
			else
				x[secret.charAt(i) - '0']++;
		}

		int cow = 0;

		for(int i = 0;i < guess.length();i++)
		{
			if(guess.charAt(i) != secret.charAt(i))
				if(--x[guess.charAt(i) - '0'] >= 0)
					cow++;
		}

		return bull + "A" + cow + "B";
	}
}