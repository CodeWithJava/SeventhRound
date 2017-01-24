// Solution One
public class Solution
{
	public TreeNode invertTree(TreeNode root)
	{
		if(root == null)
			return root;

		Queue<TreeNode> q = new LinkedList<>();
		q.offer(root);

		while(!q.isEmpty())
		{
			TreeNode x = q.poll();

			TreeNode t = x.left;
			x.left = x.right;
			x.right = t;

			if(x.left != null)
				q.offer(x.left);

			if(x.right != null)
				q.offer(x.right);
		}

		return root;
	}
}

// Solution Two
public class Solution
{
	public TreeNode invertTree(TreeNode root)
	{
		if(root == null)
			return root;

		TreeNode t = root.left;
		root.left = root.right;
		root.right = t;

		if(root.left != null)
			invertTree(root.left);

		if(root.right != null)
			invertTree(root.right);

		return root;
	}
}