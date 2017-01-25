public class Solution
{
	int [] root;

	public boolean validTree(int n, int [][] edges)
	{
		if(n < 0 || edges == null || edges.length != n - 1)
			return false;

		root = new int [n];

		for(int i = 0;i < n;i++)
			root[i] = i;

		for(int [] edge: edges)
		{
			int r1 = findRoot(edge[0]);
			int r2 = findRoot(edge[1]);

			if(r1 == r2)
				return false;

			root[r1] = r2;
		}

		return true;
	}

	private int findRoot(int x)
	{
		while(x != root[x])
			x = root[root[x]];

		return x;
	}
}