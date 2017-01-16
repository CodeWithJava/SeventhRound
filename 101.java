public class Solution
{
	public boolean isSymmetric(TreeNode root)
	{
		if(root == null)
			return true;

		Queue<TreeNode> q = new LinkedList<>();
		q.offer(root);
		q.offer(root);

		while(!q.isEmpty())
		{
			TreeNode x = q.poll();
			TreeNode y = q.poll();

			if(x == null && y == null)
				continue;
			else if(x == null || y == null)
				return false;
			else if(x.val != y.val)
				return false;

			q.offer(x.left);
			q.offer(y.right);
			q.offer(x.right);
			q.offer(y.left);
		}

		return true;
	}
}