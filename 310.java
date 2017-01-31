public class Solution
{
	public List<Integer> findMinHeightTrees(int n, int [][] edges)
	{
		List<Integer> result = new ArrayList<>();

		if(n < 1)
			return result;

		if(n == 1)
		{
			result.add(0);
			return result;
		}

		List<List<Integer>> graph = new ArrayList<>();

		for(int i = 0;i < n;i++)
			graph.add(new ArrayList<>());

		int [] inDegree = new int [n];

		for(int [] edge: edges)
		{
			graph.get(edge[0]).add(edge[1]);
			inDegree[edge[1]]++;

			graph.get(edge[1]).add(edge[0]);
			inDegree[edge[0]]++;
		}

		Queue<Integer> q = new LinkedList<>();

		for(int i = 0;i < inDegree.length;i++)
			if(inDegree[i] == 1)
				q.offer(i);

		while(n > 2)
		{
			int size = q.size();

			for(int i = 0;i < size;i++)
			{
				n--;

				int x = q.poll();

				for(int p: graph.get(x))
				{
					if(--inDegree[p] == 1)
						q.offer(p);
				}
			}
		}

		while(!q.isEmpty())
			result.add(q.poll());

		return result;
	}
}