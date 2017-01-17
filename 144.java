public class Solution
{
	public List<Integer> preorderTraversal(TreeNode root)
	{
		List<Integer> result = new ArrayList<>();

		if(root == null)
			return result;

		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);

		while(!stack.isEmpty())
		{
			TreeNode x = stack.pop();
			result.add(x.val);

			if(x.right != null)
				stack.push(x.right);

			if(x.left != null)
				stack.push(x.left);
		}

		return result;
	}
}