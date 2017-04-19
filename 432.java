public class AllOne
{
	private Bucket head;
	private Bucket tail;

	private Map<Integer, Bucket> bucketCountMap;
	private Map<String, Integer> keyCountMap;

	private class Bucket
	{
		int count;
		Set<String> keySet;
		Bucket next;
		Bucket prev;

		Bucket(int count)
		{
			this.count = count;
			keySet = new HashSet<>();
		}
	}

	AllOne()
	{
		head = new Bucket(Integer.MIN_VALUE);
		tail = new Bucket(Integer.MAX_VALUE);
		head.next = tail;
		tail.prev = head;
		bucketCountMap = new HashMap<>();
		keyCountMap = new HashMap<>();
	}

	public void inc(String key)
	{
		if(keyCountMap.containsKey(key))
			changeKey(key, 1);
		else
		{
			keyCountMap.put(key, 1);

			if(head.next.count != 1)
				addBucket(new Bucket(1), head);
				head.next.keySet.add(key);
				bucketCountMap.put(1, head.next);
		}
	}

	public void dec(String key)
	{
		if(keyCountMap.containsKey(key))
		{
			int count = keyCountMap.get(key);
			if(count == 1)
			{
				keyCountMap.remove(key);
				removeKeyFromBucket(bucketCountMap.get(count), key);
			}
			else
				changeKey(key, -1);
		}
	}

	public String getMaxKey()
	{
		return tail.prev == head ? "":(String)tail.prev.keySet.iterator().next();
	}

	public String getMinKey()
	{
		return head.next == tail ? "":(String)head.next.keySet.iterator().next();
	}

	private void changeKey(String key, int offset)
	{
		int count = keyCountMap.get(key);
		keyCountMap.put(key, count + offset);
		Bucket currBucket = bucketCountMap.get(count);
		Bucket newBucket;

		if(bucketCountMap.containsKey(count + offset))
			newBucket = bucketCountMap.get(count + offset);
		else
		{
			newBucket = new Bucket(count + offset);
			bucketCountMap.put(count + offset, newBucket);
			addBucket(newBucket, offset == 1 ? currBucket:currBucket.prev);
		}

		newBucket.keySet.add(key);
		removeKeyFromBucket(currBucket, key);
	}

	private void removeKeyFromBucket(Bucket bucket, String key)
	{
		bucket.keySet.remove(key);

		if(bucket.keySet.size() == 0)
		{
			removeBucketFromList(bucket);
			bucketCountMap.remove(bucket.count);
		}
	}

	private void removeBucketFromList(Bucket bucket)
	{
		bucket.prev.next = bucket.next;
		bucket.next.prev = bucket.prev;
		bucket.next = null;
		bucket.prev = null;
	}

	private void addBucket(Bucket newBucket, Bucket prevBucket)
	{
		newBucket.prev = prevBucket;
		newBucket.next = prevBucket.next;
		prevBucket.next.prev = newBucket;
		prevBucket.next = newBucket;
	}
}