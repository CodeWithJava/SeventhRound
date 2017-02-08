public class Solution
{
	Map<String, Queue<String>> map;
	List<String> result;

	public List<String> findItinerary(String [][] tickets)
	{
		result = new ArrayList<>();

		if(tickets == null || tickets.length == 0)
			return result;

		map = new HashMap<>();

		for(String [] ticket: tickets)
		{
			if(!map.containsKey(ticket[0]))
				map.put(ticket[0], new PriorityQueue<>());

			map.get(ticket[0]).offer(ticket[1]);
		}

		traversal("JFK");

		return result;
	}

	private void traversal(String s)
	{
		Queue<String> q = map.get(s);

		while(q != null && !q.isEmpty())
			traversal(q.poll());

		result.add(0, s);
	}
}