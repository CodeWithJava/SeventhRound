public class Solution
{
	public int [] getModifiedArray(int length, int [][] updates)
	{
		if(length == 0 || updates == null)
			return new int [0];

		int [] result = new int [length];

		for(int [] update: updates)
		{
			int l = update[0];
			int r = update[1];
			int d = update[2];

			result[l] += d;

			if(r < length - 1)
				result[r + 1] -= d;
		}

		int sum = 0;

		for(int i = 0;i < length;i++)
		{
			sum += result[i];
			result[i] = sum;
		}

		return result;
	}
}