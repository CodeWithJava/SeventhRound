public class Solution
{
	public int [] intersect(int [] nums1, int [] nums2)
	{
		if(nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0)
			return new int [0];

		Map<Integer, Integer> map = new HashMap<>();

		for(int x: nums1)
		{
			if(map.containsKey(x))
				map.put(x, map.get(x) + 1);
			else
				map.put(x, 1);
		}

		List<Integer> list = new ArrayList<>();

		for(int x: nums2)
		{
			if(map.containsKey(x))
			{
				list.add(x);

				int c = map.get(x);

				if(c > 1)
					map.put(x, c - 1);
				else
					map.remove(x);
			}
		}

		int [] result = new int [list.size()];
		int i = 0;

		for(int x: list)
			result[i++] = x;

		return result;
	}
}