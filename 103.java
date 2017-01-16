public class Solution
{
	public List<List<Integer>> zigzagLevelOrder(TreeNode root)
	{
		List<List<Integer>> result = new ArrayList<>();

		if(root == null)
			return result;

		Stack<TreeNode> curr = new Stack<>();
		curr.push(root);

		boolean l2r = true;

		while(!curr.isEmpty())
		{
			Stack<TreeNode> next = new Stack<>();
			List<Integer> t = new ArrayList<>();

			while(!curr.isEmpty())
			{
				TreeNode x = curr.pop();
				t.add(x.val);

				if(l2r)
				{
					if(x.left != null)
						next.push(x.left);

					if(x.right != null)
						next.push(x.right);
				}
				else
				{
					if(x.right != null)
						next.push(x.right);

					if(x.left != null)
						next.push(x.left);
				}
			}

			result.add(new ArrayList<>(t));
			curr = next;
			l2r = !l2r;
		}

		return result;
	}
}