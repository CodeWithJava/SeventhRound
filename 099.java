public class Solution
{
	TreeNode p;
	TreeNode m;
	TreeNode n;

	public void recoverTree(TreeNode root)
	{
		if(root == null)
			return;

		p = null;
		m = null;
		n = null;

		traversal(root);

		if(m != null && n != null)
		{
			int t = m.val;
			m.val = n.val;
			n.val = t;
		}
	}

	private void traversal(TreeNode node)
	{
		if(node == null)
			return;

		traversal(node.left);

		if(p == null)
			p = node;
		else
		{
			if(p.val > node.val)
			{
				if(m == null)
					m = p;

				n = node;
			}
			else
				p = node;
		}

		traversal(node.right);
	}
}