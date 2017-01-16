public class Solution
{
	public List<Integer> inorderTraversal(TreeNode root)
	{
		List<Integer> result = new ArrayList<>();

		if(root == null)
			return result;

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
				TreeNode t = stack.pop();
				result.add(t.val);

				p = t.right;
			}
		}

		return result;
	}
}