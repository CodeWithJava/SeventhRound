public class Solution
{
	public int maxPoints(Point [] points)
	{
		if(points == null || points.length == 0)
			return 0;

		Map<Double, Integer> map = new HashMap<>();

		int max = 0;

		for(int i = 0;i < points.length;i++)
		{
			int duplicates = 1;
			int vertical = 0;

			for(int j = i + 1;j < points.length;j++)
			{
				int x1 = points[i].x;
				int y1 = points[i].y;
				int x2 = points[j].x;
				int y2 = points[j].y;

				if(x1 == x2)
				{
					if(y1 == y2)
						duplicates++;
					else
						vertical++;
				}
				else
				{
					double slope = y1 == y2 ? 0.0:1.0 * (y1 - y2) / (x1 - x2);

					if(map.containsKey(slope))
						map.put(slope, map.get(slope) + 1);
					else
						map.put(slope, 1);
				}
			}

			for(int x: map.values())
				max = Math.max(max, x + duplicates);

			max = Math.max(max, vertical + duplicates);

			map.clear();
		}

		return max;
	}
}