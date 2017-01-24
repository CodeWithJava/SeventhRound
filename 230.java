public class Solution
{
	public int kthSmallest(TreeNode root, int k)
	{
		if(root == null || k < 1)
			throw new IllegalArgumentException("Input is invalid");

		int result = Integer.MIN_VALUE;

		Stack<TreeNode> stack = new Stack<>();
		TreeNode p = root;

		while(!stack.isEmpty() || p != null)
		{
			if(p != null)
			{
				stack.push(p);
				p = p.left;
			}
			else if(!stack.isEmpty())
			{
				TreeNode x = stack.pop();

				if(--k == 0)
				{
					result = x.val;
					break;
				}

				p = x.right;
			}
		}

		return result;
	}
}