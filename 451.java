public class Solution
{
	public String frequencySort(String s)
	{
		if(s == null || s.length() == 0)
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

		StringBuilder sb = new StringBuilder();

		while(!maxHeap.isEmpty())
		{
			Map.Entry<Character, Integer> entry = maxHeap.poll();

			char x = entry.getKey();
			int k = entry.getValue();

			for(int i = 0;i < k;i++)
				sb.append(x);
		}

		return sb.toString();
	}
}
class EntryComparator implements Comparator<Map.Entry<Character, Integer>>
{
	public int compare(Map.Entry<Character, Integer> e1, Map.Entry<Character, Integer> e2)
	{
		return e2.getValue() - e1.getValue();
	}
}