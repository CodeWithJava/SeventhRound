public class Solution
{
	public List<Integer> largestValues(TreeNode root)
	{
		List<Integer> result = new ArrayList<>();

		if(root == null)
			return result;

		int height = 1;

		Queue<TreeNode> q = new LinkedList<>();
		q.offer(root);

		while(!q.isEmpty())
		{
			int size = q.size();

			for(int i = 0;i < size;i++)
			{
				TreeNode node = q.poll();

				if(result.size() < height)
					result.add(height - 1, node.val);
				else
					result.set(height - 1, Math.max(result.get(height - 1), node.val));

				if(node.left != null)
					q.offer(node.left);

				if(node.right != null)
					q.offer(node.right);
			}

			height++;
		}

		return result;
	}
}