// Older Version
// For input type is List<Interval>
// And output type is List<Interval>
public class Solution
{
	public List<Interval> insert(List<Interval> intervals, Interval newInterval)
	{
		List<Interval> result = new ArrayList<>();

		if(intervals == null || intervals.size() == 0)
		{
			result.add(newInterval);
			return result;
		}

		Collections.sort(intervals, new IntervalComparator());

		for(Interval interval: intervals)
		{
			if(interval.end < newInterval.start)
				result.add(interval);
			else if(newInterval.end < interval.start)
			{
				result.add(newInterval);
				newInterval = interval;
			}
			else if(interval.end >= newInterval.start || newInterval.end >= interval.start)
				newInterval = new Interval(Math.min(newInterval.start, interval.start), Math.max(newInterval.end, interval.end));
		}

		result.add(newInterval);

		return result;
	}
}
class IntervalComparator implements Comparator<Interval>
{
	public int compare(Interval i1, Interval i2)
	{
		return i1.start - i2.start;
	}
}
