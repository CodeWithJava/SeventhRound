public class Solution
{
	public List<List<Integer>> levelOrderBottom(TreeNode root)
	{
		List<List<Integer>> result = new ArrayList<>();

		if(root == null)
			return result;

		Queue<TreeNode> q = new LinkedList<>();
		q.offer(root);

		while(!q.isEmpty())
		{
			List<Integer> t = new ArrayList<>();
			int size = q.size();

			for(int i = 0;i < size;i++)
			{
				TreeNode x = q.poll();
				t.add(x.val);

				if(x.left != null)
					q.offer(x.left);

				if(x.right != null)
					q.offer(x.right);
			}

			result.add(0, new ArrayList<>(t));
		}

		return result;
	}
}