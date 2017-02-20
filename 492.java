public class Solution
{
	public int [] constructRectangle(int area)
	{
		if(area < 1)
			return new int [] {-1, -1};

		int a = (int)Math.sqrt(area);

		while(area % a != 0)
			a--;

		return new int [] {area / a, a};
	}
}