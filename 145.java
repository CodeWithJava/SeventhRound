public class Solution
{
	public List<Integer> postorderTraversal(TreeNode root)
	{
		List<Integer> result = new ArrayList<>();

		if(root == null)
			return result;

		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);

		TreeNode prev = null;

		while(!stack.isEmpty())
		{
			TreeNode curr = stack.peek();

			if(prev == null || prev.left == curr  || prev.right == curr)
			{
				if(curr.left != null)
					stack.push(curr.left);
				else if(curr.right != null)
					stack.push(curr.right);
				else
				{
					stack.pop();
					result.add(curr.val);
				}
			}
			else if(curr.left == prev)
			{
				if(curr.right != null)
					stack.push(curr.right);
				else
				{
					stack.pop();
					result.add(curr.val);
				}
			}
			else if(curr.right == prev)
			{
				stack.pop();
				result.add(curr.val);
			}

			prev = curr;
		}

		return result;
	}
}