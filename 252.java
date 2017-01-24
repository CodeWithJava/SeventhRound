public class Solution
{
	public boolean canAttendMeetings(Interval [] intervals)
	{
		if(intervals == null || intervals.length == 0)
			return true;

		Arrays.sort(intervals, new IntervalComparator());

		Interval prev = intervals[0];

		for(int i = 1;i < intervals.length;i++)
		{
			Interval curr = intervals[i];

			if(prev.end > curr.start)
				return false;
			else
				prev = curr;
		}

		return true;
	}
}
class IntervalComparator implements Comparator<Interval>
{
	public int compare(Interval i1, Interval i2)
	{
		return i1.start - i2.start;
	}
}