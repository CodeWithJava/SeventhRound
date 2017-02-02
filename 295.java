public class MedianFinder
{
	Queue<Integer> min;
	Queue<Integer> max;
	/** initialize your data structure here. */
	MedianFinder()
	{
		min = new PriorityQueue<>(Collections.reverseOrder());
		max = new PriorityQueue<>();
	}

	public void addNum(int num)
	{
		min.offer(num);
		max.offer(min.poll());

		if(min.size() < max.size())
			min.offer(max.poll());
	}

	public double findMedian()
	{
		if(min.size() == max.size())
			return (double) (min.peek() + max.peek()) / 2.0;

		return (double)min.peek();
	}
}