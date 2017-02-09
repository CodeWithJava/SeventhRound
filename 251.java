public class Vector2D implements Iterator<Integer>
{
	List<Iterator<Integer>> itrs;
	int curr;

	Vector2D(List<List<Integer>> vec2d)
	{
		if(vec2d == null || vec2d.size() == 0)
			return;

		itrs = new ArrayList<>();

		for(List<Integer> x: vec2d)
			if(x.size() > 0)
				itrs.add(x.iterator());

		curr = 0;
	}

	@Override
	public Integer next()
	{
		Integer result = itrs.get(curr).next();

		if(!itrs.get(curr).hasNext())
			curr++;

		return result;
	}

	@Override
	public boolean hasNext()
	{
		if(itrs == null || itrs.size() == 0)
			return false;

		if(curr < itrs.size())
			return itrs.get(curr).hasNext();

		return false;
	}
}