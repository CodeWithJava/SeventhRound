class PeekingIterator implements Iterator<Integer>
{
	Iterator<Integer> itr;
	Integer next;

	PeekingIterator(Iterator<Integer> iterator)
	{
		// initialize any member here.

		itr = iterator;

		if(itr.hasNext())
			next = itr.next();
	}

	// Returns the next element in the iteration without advancing the iterator.
	public Integer peek()
	{
		return next;
	}

	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next()
	{
		Integer result = next;

		next = itr.hasNext() ? itr.next():null;

		return result;
	}

	@Override
	public boolean hasNext()
	{
		return next != null;
	}
}