public class Solution
{
	public String rearrangeString(String s, int k)
	{
		if(s == null || s.length() == 0 || k < 1)
			return s;

		Map<Character, Integer> map = new HashMap<>();

		for(char x: s.toCharArray())
		{
			if(map.containsKey(x))
				map.put(x, map.get(x) + 1);
			else
				map.put(x, 1);
		}

		Queue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<>(new EntryComparator());
		maxHeap.addAll(map.entrySet());

		Queue<Map.Entry<Character, Integer>> waitQueue = new LinkedList<>();

		StringBuilder sb = new StringBuilder();

		while(!maxHeap.isEmpty())
		{
			Map.Entry<Character, Integer> entry = maxHeap.poll();

			sb.append(entry.getKey());

			entry.setValue(entry.getValue() - 1);

			waitQueue.offer(entry);

			if(waitQueue.size() < k)
				continue;

			Map.Entry<Character, Integer> front = waitQueue.poll();

			if(front.getValue() > 0)
				maxHeap.offer(front);
		}

		return sb.length() == s.length() ? sb.toString():"";
	}
}
class EntryComparator implements Comparator<Map.Entry<Character, Integer>>
{
	public int compare(Map.Entry<Character, Integer> e1, Map.Entry<Character, Integer> e2)
	{
		return e2.getValue() - e1.getValue();
	}
}