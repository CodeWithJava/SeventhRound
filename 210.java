public class Solution
{
	public int [] findOrder(int numCourses, int [][] prerequisites)
	{
		if(prerequisites == null)
			throw new IllegalArgumentException("Input is invalid");

		int l = prerequisites.length;

		int [] result = new int [numCourses];

		if(l == 0)
		{
			for(int i = 0;i < numCourses;i++)
				result[i] = i;

			return result;
		}

		int [] inDegree = new int [numCourses];

		for(int i = 0;i < l;i++)
			inDegree[prerequisites[i][0]]++;

		Queue<Integer> q = new LinkedList<>();

		for(int i = 0;i < numCourses;i++)
			if(inDegree[i] == 0)
				q.offer(i);

		int numNoPre = q.size();
		int j = 0;

		while(!q.isEmpty())
		{
			int x = q.poll();
			result[j++] = x;

			for(int i = 0;i < l;i++)
			{
				if(prerequisites[i][1] == x)
				{
					if(--inDegree[prerequisites[i][0]] == 0)
					{
						q.offer(prerequisites[i][0]);
						numNoPre++;
					}
				}
			}
		}

		if(numNoPre == numCourses)
			return result;

		return new int [0];
	}
}