// Solution One
public class Solution
{
	public List<List<Integer>> combinationSum2(int [] candidates, int target)
	{
		List<List<Integer>> result = new ArrayList<>();

		if(candidates == null || candidates.length == 0)
			return result;

		Arrays.sort(candidates);

		Set<List<Integer>> set = new HashSet<>();

		List<Integer> t = new ArrayList<>();

		traversal(candidates, 0, target, t, set);

		result.addAll(set);

		return result;
	}

	private void traversal(int [] candidates, int start, int target, List<Integer> t, Set<List<Integer>> set)
	{
		if(target == 0)
			set.add(new ArrayList<>(t));
		else
		{
			for(int i = start;i < candidates.length;i++)
			{
				// Handle the case (duplicate elements in the array candidates)
				// candidates = [1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,
				// 1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,
				// 1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,
				// 1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1]
				// target = 30
				
				if(start < i && candidates[i - 1] == candidates[i])
					continue;
				if(target < candidates[i])
					return;

				t.add(candidates[i]);
				traversal(candidates, i + 1, target - candidates[i], t, set);
				t.remove(t.size() - 1);
			}
		}
	}
}

// Solution Two
class Solution {
    public List<List<Integer>> combinationSum2(int [] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();

        if (candidates == null || candidates.length == 0) {
            return result;
        }

        Arrays.sort(candidates);

        traversal(candidates, 0, target, new ArrayList<>(), result);

        return result;
    }

    private void traversal(int [] candidates, int start, int target, List<Integer> t, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(t));
        } else {
            for (int i = start;i < candidates.length;i++) {
                // Handle the duplicate result
		if (start < i && candidates[i - 1] == candidates[i]) {
                    continue;
                }

                if (candidates[i] > target) {
                    return;
                }

                t.add(candidates[i]);
                traversal(candidates, i + 1, target - candidates[i], t, result);
                t.remove(t.size() - 1);
            }
        }
    }
}
