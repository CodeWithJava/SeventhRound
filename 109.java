public class Solution
{
	ListNode p;

	public TreeNode sortedListToBST(ListNode head)
	{
		if(head == null)
			return null;

		p = head;

		ListNode x = head;
		int l = 0;

		while(x != null)
		{
			l++;
			x = x.next;
		}

		return build(0, l - 1);
	}

	private TreeNode build(int l, int r)
	{
		if(l > r)
			return null;

		int m = l + (r - l) / 2;

		TreeNode left = build(l, m - 1);
		TreeNode node = new TreeNode(p.val);
		p = p.next;
		TreeNode right = build(m + 1, r);

		node.left = left;
		node.right = right;

		return node;
	}
}