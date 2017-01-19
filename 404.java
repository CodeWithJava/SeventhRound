public class Solution
{
	public int sumOfLeftLeaves(TreeNode root)
	{
		if(root == null)
			return 0;

		int result = 0;
		Queue<TreeNode> q = new LinkedList<>();
		q.offer(root);

		while(!q.isEmpty())
		{
			TreeNode x = q.poll();

			if(x.left != null && x.left.left == null && x.left.right == null)
				result += x.left.val;

			if(x.left != null)
				q.offer(x.left);

			if(x.right != null)
				q.offer(x.right);
		}

		return result;
	}
}