public class Solution
{
	public int findRadius(int [] houses, int [] heaters)
	{
		int result = Integer.MIN_VALUE;

		Arrays.sort(heaters);

		for(int house: houses)
		{
			int idx = Arrays.binarySearch(heaters, house);

			if(idx < 0)
				idx = - (idx + 1);

			int l = idx - 1 >= 0 ? house - heaters[idx - 1]:Integer.MAX_VALUE;
			int r = idx < heaters.length ? heaters[idx] - house:Integer.MAX_VALUE;

			result = Math.max(result, Math.min(l, r));
		}

		return result;
	}
}