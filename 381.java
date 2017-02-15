public class RandomizedCollection
{
	Map<Integer, Set<Integer>> p;
	Map<Integer, Integer> q;

	/** Initialize your data structure here. */
	RandomizedCollection()
	{
		p = new HashMap<>();
		q = new HashMap<>();
	}

	/** Inserts a value to the collection. Returns true if the collection did not already
	    contain the specified element. */
	public boolean insert(int val)
	{
		int n = q.size();
		q.put(n + 1, val);

		if(p.containsKey(val))
		{
			p.get(val).add(n + 1);
			return false;
		}
		else
		{
			Set<Integer> t = new HashSet<>();
			t.add(n + 1);
			p.put(val, t);
			return true;
		}
	}

	/** Remove a value from the collection. Returns true if the colletion contained
	    the specified element. */
	public boolean remove(int val)
	{
		if(p.containsKey(val))
		{
			Set<Integer> t = p.get(val);
			int toRemove = t.iterator().next();
			t.remove(toRemove);

			if(t.size() == 0)
				p.remove(val);

			if(toRemove == q.size())
			{
				q.remove(toRemove);
				return true;
			}

			int n = q.size();
			int x = q.get(n);

			Set<Integer> set = p.get(x);
			set.remove(n);
			set.add(toRemove);

			q.remove(n);
			q.put(toRemove, x);

			return true;
		}
		else
			return false;
	}

	/** Get a random element from the collection. */
	public int getRandom()
	{
		if(q.size() == 0)
			return -1;

		return q.get(new Random().nextInt(q.size()) + 1);
	}
}