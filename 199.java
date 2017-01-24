public class Solution
{
	public List<Integer> rightSideView(TreeNode root)
	{
		List<Integer> result = new ArrayList<>();

		if(root == null)
			return result;

		Queue<TreeNode> q = new LinkedList<>();
		q.offer(root);

		while(!q.isEmpty())
		{
			int size = q.size();

			for(int i = 0;i < size;i++)
			{
				TreeNode x = q.poll();

				if(i == 0)
					result.add(x.val);

				if(x.right != null)
					q.offer(x.right);

				if(x.left != null)
					q.offer(x.left);
			}
		}

		return result;
	}
}