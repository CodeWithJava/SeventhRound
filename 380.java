public class RandomizedSet
{
	Map<Integer, Integer> p;
	Map<Integer, Integer> q;

	/** Initialize your data structure here. */
	RandomizedSet()
	{
		p = new HashMap<>();
		q = new HashMap<>();
	}

	/** Inserts a value into the set. Returns true if the set did not already contain
	    the specified element. */
	public boolean insert(int val)
	{
		if(!p.containsKey(val))
		{
			p.put(val, p.size());
			q.put(q.size(), val);
			return true;
		}
		else
			return false;
	}

	/** Removes a value from the set. Returns true if the set contained the specified
	    element. */
	public boolean remove(int val)
	{
		if(p.containsKey(val))
		{
			int i = p.get(val);

			p.remove(val);
			q.remove(i);

			if(p.size() == 0 || i == p.size())
				return true;

			int x = q.get(q.size());
			q.remove(q.size());
			q.put(i, x);
			p.put(x, i);

			return true;
		}
		else
			return false;
	}

	/** Get a random element from the set. */
	public int getRandom()
	{
		if(q.size() == 0)
			return -1;

		return q.get(new Random().nextInt(q.size()));
	}
}