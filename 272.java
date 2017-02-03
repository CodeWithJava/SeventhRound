public class Solution
{
	public List<Integer> closestKValues(TreeNode root, double target, int k)
	{
		Queue<Integer> q = new LinkedList<>();

		if(root == null)
			return (List<Integer>)q;

		Stack<TreeNode> stack = new Stack<>();
		TreeNode p = root;

		while(p != null)
		{
			stack.push(p);
			p = p.left;
		}

		while(!stack.isEmpty())
		{
			TreeNode x = stack.pop();

			if(q.size() < k)
				q.offer(x.val);
			else
			{
				if(Math.abs(target - q.peek()) > Math.abs(target - x.val))
				{
					q.poll();
					q.offer(x.val);
				}
				else
					break;
			}

			if(x.right != null)
			{
				x = x.right;

				while(x != null)
				{
					stack.push(x);
					x = x.left;
				}
			}
		}

		return (List<Integer>)q;
	}
}