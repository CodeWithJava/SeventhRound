public class LFUCache
{
	Map<Integer, Integer> map;
	Map<Integer, Integer> counts;
	Map<Integer, LinkedHashSet<Integer>> list;

	int capacity;
	int min;

	LFUCache(int capacity)
	{
		this.capacity = capacity;
		this.min = 1;
		map = new HashMap<>();
		counts = new HashMap<>();
		list = new HashMap<>();
		list.put(1, new LinkedHashSet<>());
	}

	public int get(int key)
	{
		if(!map.containsKey(key))
			return -1;

		int count = counts.get(key);
		counts.put(key, count + 1);
		list.get(count).remove(key);

		if(count == min && list.get(count).size() == 0)
			min++;

		if(!list.containsKey(count + 1))
			list.put(count + 1, new LinkedHashSet<>());

		list.get(count + 1).add(key);
		return map.get(key);
	}

	public void put(int key, int value)
	{
		if(capacity < 1)
			return;

		if(map.containsKey(key))
		{
			map.put(key, value);
			get(key);
			return;
		}

		if(map.size() == capacity)
		{
			int evit = list.get(min).iterator().next();
			list.get(min).remove(evit);
			map.remove(evit);
		}

		map.put(key, value);
		counts.put(key, 1);
		min = 1;
		list.get(1).add(key);
	}
}