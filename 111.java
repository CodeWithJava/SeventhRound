public class Solution
{
	public int minDepth(TreeNode root)
	{
		if(root == null)
			return 0;

		Queue<TreeNode> q = new LinkedList<>();
		q.offer(root);
		Queue<Integer> d = new LinkedList<>();
		d.offer(1);

		while(!q.isEmpty())
		{
			TreeNode x = q.poll();
			int depth = d.poll();

			if(x.left == null && x.right == null)
				return depth;

			if(x.left != null)
			{
				q.offer(x.left);
				d.offer(depth + 1);
			}

			if(x.right != null)
			{
				q.offer(x.right);
				d.offer(depth + 1);
			}
		}

		return 0;
	}
}