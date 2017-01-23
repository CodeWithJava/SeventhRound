public class Solution
{
	public boolean canFinish(int numCourses, int [][] prerequisites)
	{
		if(numCourses == 0 || prerequisites == null || prerequisites.length == 0)
			return true;

		int l = prerequisites.length;

		int [] inDegree = new int [numCourses];

		for(int i = 0;i < l;i++)
			inDegree[prerequisites[i][0]]++;

		Queue<Integer> q = new LinkedList<>();

		for(int i = 0;i < numCourses;i++)
			if(inDegree[i] == 0)
				q.offer(i);

		int numNoPre = q.size();

		while(!q.isEmpty())
		{
			int x = q.poll();

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

		return numNoPre == numCourses;
	}
}