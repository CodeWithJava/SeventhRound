public class Solution
{
	public String alienOrder(String [] words)
	{
		if(words == null || words.length == 0)
			return "";

		Map<Character, AlienChar> graph = new HashMap<>();

		boolean isSuccessed = buildGraph(words, graph);

		if(!isSuccessed)
			return "";

		String order = findOrder(graph);

		return order.length() == graph.size() ? order:"";
	}

	private boolean buildGraph(String [] words, Map<Character, AlienChar> graph)
	{
		initialize(words, graph);

		Set<String> exist = new HashSet<>();

		for(int i = 1;i < words.length;i++)
		{
			String p = words[i - 1];
			String q = words[i];

			Character prev = null;
			Character next = null;

			for(int j = 0;j < p.length() && j < q.length();j++)
			{
				if(p.charAt(j) != q.charAt(j))
				{
					prev = p.charAt(j);
					next = q.charAt(j);
					break;
				}
			}

			if(prev != null && exist.contains(next + "" + prev))
				return false;

			if(prev != null && !exist.contains(prev + "" + next))
			{
				addEdge(graph, prev, next);
				exist.add(prev + "" + next);
			}
		}

		return true;
	}

	private void initialize(String [] words, Map<Character, AlienChar> graph)
	{
		for(String word: words)
			for(int i = 0;i < word.length();i++)
				if(!graph.containsKey(word.charAt(i)))
					graph.put(word.charAt(i), new AlienChar(word.charAt(i)));
	}

	private void addEdge(Map<Character, AlienChar> graph, char prev, char next)
	{
		AlienChar prevAlienChar = graph.get(prev);
		AlienChar nextAlienChar = graph.get(next);

		prevAlienChar.nextVertexes.add(nextAlienChar);
		nextAlienChar.inDegree++;

		graph.put(prev, prevAlienChar);
		graph.put(next, nextAlienChar);
	}

	private String findOrder(Map<Character, AlienChar> graph)
	{
		Queue<AlienChar> q = new LinkedList<>();

		for(char x: graph.keySet())
			if(graph.get(x).inDegree == 0)
				q.offer(graph.get(x));

		StringBuilder sb = new StringBuilder();

		while(!q.isEmpty())
		{
			AlienChar c = q.poll();
			sb.append(c.val);

			for(AlienChar x: c.nextVertexes)
				if(--x.inDegree == 0)
					q.offer(x);
		}

		return sb.toString();
	}
}
class AlienChar
{
	char val;
	int inDegree;
	List<AlienChar> nextVertexes;

	AlienChar(char val)
	{
		this.val = val;
		inDegree = 0;
		nextVertexes = new ArrayList<>();
	}
}