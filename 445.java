public class Solution
{
	public ListNode addTwoNumbers(ListNode l1, ListNode l2)
	{
		if(l1 == null)
			return l2;

		if(l2 == null)
			return l1;

		Stack<Integer> p = new Stack<>();
		Stack<Integer> q = new Stack<>();

		ListNode m = l1;

		while(m != null)
		{
			p.push(m.val);
			m = m.next;
		}

		ListNode n = l2;

		while(n != null)
		{
			q.push(n.val);
			n = n.next;
		}

		ListNode dummyNode = new ListNode(0);

		int carry = 0;

		while(!p.isEmpty() || !q.isEmpty())
		{
			int x = p.isEmpty() ? 0:p.pop();
			int y = q.isEmpty() ? 0:q.pop();

			int sum = carry + x + y;
			carry = sum / 10;

			ListNode node = new ListNode(sum % 10);
			node.next = dummyNode.next;
			dummyNode.next = node;
		}

		if(carry != 0)
		{
			dummyNode.val = carry;
			return dummyNode;
		}

		return dummyNode.next;
	}
}