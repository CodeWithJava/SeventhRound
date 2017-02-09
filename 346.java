public class MovingAverage
{
	int size;
	Queue<Integer> q;
	int sum;

	/** Initialize your data structure here. */
	MovingAverage(int size)
	{
		this.size = size;
		q = new LinkedList<>();
		sum = 0;
	}

	public double next(int val)
	{
		sum += val;
		q.offer(val);

		if(q.size() > size)
			sum -= q.poll();

		return (double) sum / q.size();
	}
}