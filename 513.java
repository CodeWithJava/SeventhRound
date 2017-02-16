public class Solution
{
	public int findBottomLeftValue(TreeNode root)
	{
		if(root == null)
			throw new IllegalArgumentException("Input is invalid");

		int result = 0;
		Queue<TreeNode> q = new LinkedList<>();
		q.offer(root);

		while(!q.isEmpty())
		{
			int size = q.size();

			for(int i = 0;i < size;i++)
			{
				TreeNode node = q.poll();

				if(i == 0)
					result = node.val;

				if(node.left != null)
					q.offer(node.left);

				if(node.right != null)
					q.offer(node.right);
			}
		}

		return result;
	}
}