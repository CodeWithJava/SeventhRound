public class Solution
{
	public int numberOfBoomerangs(int [][] points)
	{
		if(points == null || points.length == 0 || points[0].length == 0)
			return 0;

		int r = points.length;

		Map<Integer, Integer> map = new HashMap<>();

		int result = 0;

		for(int i = 0;i < r;i++)
		{
			for(int j = 0;j < r;j++)
			{
				if(i == j)
					continue;

				int d = getDistance(points[i], points[j]);

				map.put(d, map.getOrDefault(d, 0) + 1);
			}

			for(int x: map.values())
				result += x * (x - 1);

			map.clear();
		}

		return result;
	}

    private int getDistance(int [] x, int [] y)
    {
        return (int)Math.abs(Math.pow(x[0] - y[0], 2) + Math.pow(x[1] - y[1], 2));
    }
}