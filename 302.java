public class Solution
{
	public int minArea(char [][] image, int x, int y)
	{
		if(image == null || image.length == 0 || image[0].length == 0 || x < 0 || x > image.length - 1 || y < 0 || y > image[0].length - 1)
			return 0;

		int r = image.length;
		int c = image[0].length;

		int m;

		int i = x;
		int j = r - 1;

		while(i < j)
		{
			m = i + (j - i) / 2 + 1;

			if(checkRow(image, m))
				i = m;
			else
				j = m - 1;
		}

		int bottom = i;

		i = 0;
		j = x;

		while(i < j)
		{
			m = i + (j - i) / 2;

			if(checkRow(image, m))
				j = m;
			else
				i = m + 1;
		}

		int top = i;

		i = y;
		j = c - 1;

		while(i < j)
		{
			m = i + (j - i) / 2 + 1;

			if(checkCol(image, m))
				i = m;
			else
				j = m - 1;
		}

		int right = i;

		i = 0;
		j = y;

		while(i < j)
		{
			m = i + (j - i) / 2;

			if(checkCol(image, m))
				j = m;
			else
				i = m + 1;
		}

		int left = i;

		return (right - left + 1) * (bottom - top + 1);
	}

	private boolean checkRow(char [][] image, int m)
	{
		for(int i = 0;i < image[0].length;i++)
			if(image[m][i] == '1')
				return true;

		return false;
	}

	private boolean checkCol(char [][] image, int m)
	{
		for(int i = 0;i < image.length;i++)
			if(image[i][m] == '1')
				return true;

		return false;
	}
}