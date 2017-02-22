public class Solution
{
	public int findPoisonedDuration(int [] timeSeries, int duration)
	{
		if(timeSeries == null || timeSeries.length == 0 || duration < 1)
			return 0;

		int total = 0;
		int begin = timeSeries[0];

		for(int t: timeSeries)
		{
			total += t < begin + duration ? t - begin:duration;
			begin = t;
		}

		return total + duration;
	}
}