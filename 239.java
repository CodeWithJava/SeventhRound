// Solution One
public class Solution
{
	public int [] maxSlidingWindow(int [] nums, int k)
	{
		if(nums == null || nums.length == 0 || k < 1 || k > nums.length)
			return new int [0];

		int [] result = new int [nums.length - k + 1];

		Queue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

		for(int i = 0;i < nums.length;i++)
		{
			maxHeap.offer(nums[i]);

			if(maxHeap.size() > k)
				maxHeap.remove(nums[i - k]);

			if(i >= k - 1)
				result[i - k + 1] = maxHeap.peek();
		}

		return result;
	}
}

// Solution Two
public class Solution
{
	public int [] maxSlidingWindow(int [] nums, int k)
	{
		if(nums == null || nums.length == 0 || k < 1 || k > nums.length)
			return new int [0];

		int [] result = new int [nums.length - k + 1];

		LinkedList<Integer> q = new LinkedList<>();

		for(int i = 0;i < nums.length;i++)
		{
			if(!q.isEmpty() && q.peek() == i - k)
				q.poll();

			while(!q.isEmpty() && nums[q.peekLast()] < nums[i])
				q.removeLast();

			q.offer(i);

			if(i >= k - 1)
				result[i - k + 1] = nums[q.peek()];
		}

		return result;
	}
}