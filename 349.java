public class Solution
{
	public int [] intersection(int [] nums1, int [] nums2)
	{
		if(nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0)
			return new int [0];

		Set<Integer> p = new HashSet<>();

		for(int x: nums1)
			p.add(x);

		Set<Integer> q = new HashSet<>();

		for(int x: nums2)
			q.add(x);

		Iterator<Integer> x = p.iterator();

		while(x.hasNext())
		{
			if(!q.contains(x.next()))
				x.remove();
		}

		int [] result = new int [p.size()];

		int i = 0;

		for(int w: p)
			result[i++] = w;

		return result;
	}
}