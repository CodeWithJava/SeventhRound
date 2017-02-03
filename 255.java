// Solution One
public class Solution
{
	public boolean verifyPreorder(int [] preorder)
	{
		if(preorder == null || preorder.length == 0)
			return true;

		return verifyPreorder(preorder, 0, preorder.length);
	}

	private boolean verifyPreorder(int [] preorder, int l, int r)
	{
		if(l >= r - 1)
			return true;

		int root = preorder[l];

		int i = l + 1;

		while(i < r && preorder[i] < root)
			i++;

		if(i < r)
		{
			int j = i;

			while(j < r && preorder[j] > root)
				j++;

			if(j < r)
				return false;

			return verifyPreorder(preorder, l + 1, i) && verifyPreorder(preorder, i, r);
		}
		else
			return verifyPreorder(preorder, l + 1, r);
	}
}

// Solution Two
public class Solution
{
	public boolean verifyPreorder(int [] preorder)
	{
		if(preorder == null || preorder.length == 0)
			return true;

		Stack<Integer> stack = new Stack<>();
		int min = Integer.MIN_VALUE;

		for(int x: preorder)
		{
			if(x < min)
				return false;

			while(!stack.isEmpty() && x > stack.peek())
				min = stack.pop();

			stack.push(x);
		}

		return true;
	}
}

// Solution Three
public class Solution
{
	public boolean verifyPreorder(int [] preorder)
	{
		if(preorder == null || preorder.length == 0)
			return true;

		int i = -1;
		int min = Integer.MIN_VALUE;

		for(int x: preorder)
		{
			if(x < min)
				return false;

			while(i >= 0 && x > preorder[i])
				min = preorder[i--];

			preorder[++i] = x;
		}

		return true;
	}
}