// Solution One
public class Solution
{
	public TreeNode inorderSuccessor(TreeNode root, TreeNode p)
	{
		if(root == null || p == null)
			return null;

		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);

		boolean isNext = false;

		while(!stack.isEmpty())
		{
			TreeNode node = stack.pop();

			if(node.left == null && node.right == null)
			{
				if(isNext)
					return node;

				if(node.val == p.val)
					isNext = true;

				continue;
			}

			if(node.right != null)
			{
				stack.push(node.right);
				node.right = null;
			}

			stack.push(node);

			if(node.left != null)
			{
				stack.push(node.left);
				node.left = null;
			}
		}

		return null;
	}
}

// Solution Two
public class Solution
{
	public TreeNode inorderSuccessor(TreeNode root, TreeNode p)
	{
		if(root == null || p == null)
			return null;

		TreeNode result = null;

		while(root != null)
		{
			if(p.val < root.val)
			{
				result = root;
				root = root.left;
			}
			else
				root = root.right;
		}

		return result;
	}
}