public class PhoneDirectory
{
	int max;
	Set<Integer> set;
	Queue<Integer> q;

	/** Initialize your data structure here
		@param maxNumbers - The maximum numbers that can be stored in the phone directory. */
	PhoneDirectory(int maxNumbers)
	{
		set = new HashSet<>();
		q = new LinkedList<>();

		for(int i = 0;i < maxNumbers;i++)
			q.offer(i);

		max = maxNumbers - 1;
	}
	
	/** Provide a number which is not assigned to anyone.
		@return - Return an available number. Return -1 if none is available. */
	public int get()
	{
		if(q.isEmpty())
			return -1;

		int x = q.poll();
		set.add(x);

		return x;
	}
	
	/** Check if a number is available or not. */
	public boolean check(int number)
	{
		return !set.contains(number) && number <= max;
	}
	
	/** Recycle or release a number. */
	public void release(int number)
	{
		if(set.contains(number))
		{
			set.remove(number);
			q.offer(number);
		}
	}
}