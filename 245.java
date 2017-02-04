public class Solution
{
	public int shortestWordDistance(String [] words, String word1, String word2)
	{
		if(words == null || words.length == 0)
			return -1;

		int p = -1;
		int q = -1;

		int min = Integer.MAX_VALUE;

		for(int i = 0;i < words.length;i++)
		{
			if(word1.equals(word2))
			{
				if(words[i].equals(word1))
				{
					if(p > q)
						q = i;
					else
						p = i;
				}
			}
			else
			{
				if(words[i].equals(word1))
					p = i;

				if(words[i].equals(word2))
					q = i;
			}

			if(p != -1 && q != -1)
				min = Math.min(min, Math.abs(p - q));
		}

		return min;
	}
}