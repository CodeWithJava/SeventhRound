public class Solution
{
	public int countComponents(int n, int [][] edges)
	{
		if(n < 1)
			return -1;

		if(edges == null || edges.length == 0)
			return n;

		int count = n;

		int [] roots = new int [n];

		for(int i = 0;i < n;i++)
			roots[i] = i;

		for(int [] edge: edges)
		{
			int x = findRoot(roots, edge[0]);
			int y = findRoot(roots, edge[1]);

			if(x != y)
			{
				roots[x] = y;
				count--;
			}
		}

		return count;
	}

	private int findRoot(int [] roots, int x)
	{
		while(x != roots[x])
			x = roots[roots[x]];

		return x;
	}
}