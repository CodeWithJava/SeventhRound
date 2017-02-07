public class Solution
{
	public int maxProduct(String [] words)
	{
		if(words == null || words.length == 0)
			return 0;

		int l = words.length;
		int [] records = new int [l];

		for(int i = 0; i < l;i++)
			for(char x: words[i].toCharArray())
				records[i] |= 1 << (x - 'a');

		int max = 0;

		for(int i = 0;i < l;i++)
			for(int j = i + 1;j < l;j++)
				if((records[i] & records[j]) == 0)
					max = Math.max(max, words[i].length() * words[j].length());

		return max;
	}
}