public class Solution
{
	public boolean hasPathSum(TreeNode root, int sum)
	{
		if(root == null)
			return false;

		Queue<TreeNode> q = new LinkedList<>();
		q.offer(root);
		Queue<Integer> s = new LinkedList<>();
		s.offer(root.val);

		while(!q.isEmpty())
		{
			TreeNode x = q.poll();
			int w = s.poll();

			if(w == sum && x.left == null && x.right == null)
				return true;

			if(x.left != null)
			{
				q.offer(x.left);
				s.offer(w + x.left.val);
			}

			if(x.right != null)
			{
				q.offer(x.right);
				s.offer(w + x.right.val);
			}
		}

		return false;
	}
}