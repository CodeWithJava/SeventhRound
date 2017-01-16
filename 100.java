public class Solution
{
	public boolean isSameTree(TreeNode p, TreeNode q)
	{
		if(p == null && q == null)
			return true;
		else if(p == null || q == null)
			return false;
		else if(p.val != q.val)
			return false;

		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(p);
		queue.offer(q);

		while(!queue.isEmpty())
		{
			TreeNode x = queue.poll();
			TreeNode y = queue.poll();

			if(x == null && y == null)
				continue;
			else if(x == null || y == null)
				return false;
			else if(x.val != y.val)
				return false;

			queue.offer(x.left);
			queue.offer(y.left);
			queue.offer(x.right);
			queue.offer(y.right);
		}

		return true;
	}
}