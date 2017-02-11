public class Solution
{
	public List<Integer> topKFrequent(int [] nums, int k)
	{
		List<Integer> result = new ArrayList<>();

		if(nums == null || nums.length == 0 || k < 1)
			return result;

		Map<Integer, Integer> map = new HashMap<>();

		for(int x: nums)
		{
			if(map.containsKey(x))
				map.put(x, map.get(x) + 1);
			else
				map.put(x, 1);
		}

		Queue<Pair> minHeap = new PriorityQueue<>(new PairComparator());

		for(Map.Entry<Integer, Integer> entry: map.entrySet())
		{
			Pair pair = new Pair(entry.getKey(), entry.getValue());

			minHeap.offer(pair);

			if(minHeap.size() > k)
				minHeap.poll();
		}

		while(!minHeap.isEmpty())
			result.add(minHeap.poll().val);

		return result;
	}
}
class Pair
{
	int val;
	int count;

	Pair(int val, int count)
	{
		this.val = val;
		this.count = count;
	}
}
class PairComparator implements Comparator<Pair>
{
	public int compare(Pair p1, Pair p2)
	{
		return p1.count - p2.count;
	}
}