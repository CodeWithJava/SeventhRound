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

// Newer Version
// For the current input and output type
class Solution {
    public int [][] insert(int [][] intervals, int [] newInterval) {
        if (intervals == null || intervals.length == 0) {
            return new int [][] {newInterval};
        }

	// There is a constraint
	// the intervals is sorted by start in ascending order
	// if not, it should uncomment the following code statement.
	// Arrays.sort(intervals, (i1, i2) -> Integer.compare(i1[0], i2[0]));

        List<int []> t = new ArrayList<>();

        for (int [] interval: intervals) {
            if (interval[1] < newInterval[0]) {
                t.add(interval);
            } else if (newInterval[1] < interval[0]) {
                t.add(newInterval);
                newInterval = interval;
            } else if (interval[1] >= newInterval[0] || newInterval[1] >= interval[0]) {
                newInterval = new int [] {Math.min(interval[0], newInterval[0]), Math.max(interval[1], newInterval[1])};
            }
        }

        t.add(newInterval);

        return t.toArray(new int [t.size()][]);
    }
}
