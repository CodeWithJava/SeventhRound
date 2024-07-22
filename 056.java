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

// Newer Version
// For the current input and output type
class Solution {
    public int [][] merge(int [][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return new int [0][0];
        }

        Arrays.sort(intervals, (i1, i2) -> Integer.compare(i1[0], i2[0]));

        List<int []> t = new ArrayList<>();
        int [] prev = intervals[0];

        for (int i = 1;i < intervals.length;i++){
            int [] curr = intervals[i];

            if (prev[1] < curr[0]) {
                t.add(prev);
                prev = curr;
            } else {
                prev = new int [] {prev[0], Math.max(prev[1], curr[1])};
            }
        }

        t.add(prev);

        return t.toArray(new int [t.size()][]);
    }
}
