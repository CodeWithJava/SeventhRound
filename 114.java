public class Solution
{
	public void flatten(TreeNode root)
	{
		if(root == null)
			return;

		Stack<TreeNode> stack = new Stack<>();
		TreeNode p = root;

		while(!stack.isEmpty() || p != null)
		{
			if(p.right != null)
				stack.push(p.right);

			if(p.left != null)
			{
				p.right = p.left;
				p.left = null;
			}
			else if(!stack.isEmpty())
				p.right = stack.pop();

			p = p.right;
		}
	}
}