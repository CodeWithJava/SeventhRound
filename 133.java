public class Solution
{
	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node)
	{
		if(node == null)
			return node;

		UndirectedGraphNode source = new UndirectedGraphNode(node.label);
		Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
		map.put(node, source);
		Queue<UndirectedGraphNode> q = new LinkedList<>();
		q.offer(node);

		while(!q.isEmpty())
		{
			UndirectedGraphNode x = q.poll();
			List<UndirectedGraphNode> neighbors = x.neighbors;

			for(UndirectedGraphNode neighbor: neighbors)
			{
				if(map.containsKey(neighbor))
					map.get(x).neighbors.add(map.get(neighbor));
				else
				{
					UndirectedGraphNode clone = new UndirectedGraphNode(neighbor.label);
					map.get(x).neighbors.add(clone);
					map.put(neighbor, clone);
					q.offer(neighbor);
				}
			}
		}

		return source;
	}
}