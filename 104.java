public class Solution
{
	public int maxDepth(TreeNode root)
	{
		if(root == null)
			return 0;

		int depth = 0;

		Queue<TreeNode> q = new LinkedList<>();
		q.offer(root);

		while(!q.isEmpty())
		{
			int size = q.size();

			for(int i = 0;i < size;i++)
			{
				TreeNode x = q.poll();

				if(x.left != null)
					q.offer(x.left);

				if(x.right != null)
					q.offer(x.right);
			}

			depth++;
		}

		return depth;
	}
}