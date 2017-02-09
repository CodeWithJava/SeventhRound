public class Solution
{
	public boolean isReflected(int [][] points)
	{
		if(points == null || points.length == 0 || points[0].length == 0)
			return true;

		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;

		Set<String> set = new HashSet<>();

		for(int [] point: points)
		{
			min = Math.min(min, point[0]);
			max = Math.max(max, point[0]);

			set.add(point[0] + "*" + point[1]);
		}

		int sum = min + max;

		for(int [] point: points)
		{
			if(!set.contains((sum - point[0]) + "*" + point[1]))
				return false;
		}

		return true;
	}
}