// Older Version
// For input type is List<Interval>
// And output type is List<Interval>
public class Solution
{
	public List<Interval> merge(List<Interval> intervals)
	{
		if(intervals == null || intervals.size() == 0)
			return intervals;

		List<Interval> result = new ArrayList<>();

		Collections.sort(intervals, new IntervalComparator());

		Interval prev = intervals.get(0);

		for(int i = 1;i < intervals.size();i++)
		{
			Interval curr = intervals.get(i);

			if(prev. end < curr.start)
			{
				result.add(prev);
				prev = curr;
			}
			else
				prev = new Interval(prev.start, Math.max(prev.end, curr.end));
		}

		result.add(prev);

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
