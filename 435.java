public class Solution
{
	public int eraseOverlapIntervals(Interval [] intervals)
	{
		if(intervals == null || intervals.length == 0)
			return 0;

		Arrays.sort(intervals, (p, q) -> p.end - q.end);

		int end = intervals[0].end;
		int count = 1;

		for(int i = 1;i < intervals.length;i++)
		{
			if(end <= intervals[i].start)
			{
				end = intervals[i].end;
				count++;
			}
		}

		return intervals.length - count;
	}
}