public class Solution
{
	public int [][] reconstructQueue(int [][] people)
	{
		if(people == null || people.length == 0 || people[0].length == 0)
			return new int [0][0];

		Arrays.sort(people, new Comparator<int []>(){
			public int compare(int [] p, int [] q)
			{
				if(p[0] == q[0])
					return p[1] - q[1];

				return q[0] - p[0];
			}
		});

		List<int []> t = new ArrayList<>();

		for(int i = 0;i < people.length;i++)
			t.add(people[i][1], new int [] {people[i][0], people[i][1]});

		int [][] result = new int [people.length][2];

		int i = 0;

		for(int [] x: t)
		{
			result[i][0] = x[0];
			result[i][1] = x[1];
			i++;
		}

		return result;
	}
}