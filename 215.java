// Solution One
public class Solution
{
	public int findKthLargest(int [] nums, int k)
	{
		if(nums == null || nums.length == 0 || k > nums.length)
			throw new IllegalArgumentException("Input is invalid");

		buildHeap(nums);

		int size = nums.length;

		for(int i = 1;i < k;i++)
		{
			swap(nums, 0, size - 1);
			size--;
			maxHeap(nums, 0, size);
		}

		return nums[0];
	}

	private void buildHeap(int [] nums)
	{
		for(int i = nums.length / 2;i >= 0;i--)
			maxHeap(nums, i, nums.length);
	}

	private void maxHeap(int [] nums, int parent, int size)
	{
		int l = parent * 2 + 1;
		int r = l + 1;
		int largest = parent;

		if(l < size && nums[l] > nums[largest])
			largest = l;

		if(r < size && nums[r] > nums[largest])
			largest = r;

		if(largest != parent)
		{
			swap(nums, largest, parent);
			maxHeap(nums, largest, size);
		}
	}

	private void swap(int [] nums, int i, int j)
	{
		nums[i] ^= nums[j];
		nums[j] ^= nums[i];
		nums[i] ^= nums[j];
	}
}

// Solution Two
public class Solution
{
	public int findKthLargest(int [] nums, int k)
	{
		if(nums == null || nums.length == 0 || k > nums.length)
			throw new IllegalArgumentException("Input is invalid");

		return findKth(nums, 0, nums.length - 1, nums.length - k);
	}

	private int findKth(int [] nums, int l, int r, int indexK)
	{
		int i = l;
		int j = r;
		int p = nums[r];

		while(i < j)
		{
			while(i < j && nums[i] < p)
				i++;
			while(i < j && p <= nums[j])
				j--;

			swap(nums, i, j);
		}

		swap(nums, i, r);

		if(i == indexK)
			return nums[i];
		else if(i < indexK)
			return findKth(nums, i + 1, r, indexK);
		else
			return findKth(nums, l, i - 1, indexK);
	}

	private void swap(int [] nums, int i, int j)
	{
		int t = nums[i];
		nums[i] = nums[j];
		nums[j] = t;
	}
}