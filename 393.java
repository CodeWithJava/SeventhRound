public class Solution
{
	public boolean validUtf8(int [] data)
	{
		if(data == null)
			return false;

		if(data.length == 0)
			return true;

		if((data[0] & 0b11111000) == 0b11111000)
			return false;

		int mask = 0b10000000;
		int check = 0;

		for(int i = 0;i < data.length;i++)
		{
			if(check > 0)
			{
				if((data[i] & mask) == mask)
					check--;
				else
					return false;
			}
			else
			{
				check = getOneBitCountFromHead(data[i]);

				if(check < 0)
					return false;
			}
		}

		return check == 0;
	}

	private int getOneBitCountFromHead(int x)
	{
		if((x & 0b11110000) == 0b11110000)	return 3;
		if((x & 0b11100000) == 0b11100000)	return 2;
		if((x & 0b11000000) == 0b11000000)	return 1;
		if((x & 0b10000000) == 0b10000000)	return -1;

		return 0;
	}
}