public class ZigzagIterator
{
	List<Iterator<Integer>> itrs;
	int curr;

	ZigzagIterator(List<Integer> v1, List<Integer> v2)
	{
		itrs = new ArrayList<>();

		if(v1 != null && v1.size() > 0)
			itrs.add(v1.iterator());

		if(v2 != null && v2.size() > 0)
			itrs.add(v2.iterator());

		curr = 0;
	}

	public int next()
	{
		curr %= itrs.size();

		Iterator<Integer> x = itrs.get(curr);

		int result = x.next();

		if(!x.hasNext())
		{
			itrs.remove(curr);
			curr--;
		}

		curr++;

		return result;
	}

	public boolean hasNext()
	{
		return itrs.size() > 0;
	}
}