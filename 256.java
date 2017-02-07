public class Solution
{
	public int minCost(int [][] costs)
	{
		if(costs == null || costs.length == 0)
			return 0;

		int r = costs[0][0];
		int b = costs[0][1];
		int g = costs[0][2];

		for(int i = 1;i < costs.length;i++)
		{
			int tr = r;
			int tb = b;

			r = costs[i][0] + Math.min(b, g);
			b = costs[i][1] + Math.min(tr, g);
			g = costs[i][2] + Math.min(tr, tb);
		}

		return Math.min(r, Math.min(b, g));
	}
}