public class Solution
{
	public void reorderList(ListNode head)
	{
		if(head == null || head.next == null)
			return;

		ListNode fast = head;
		ListNode slow = head;

		while(fast.next != null && fast.next.next != null)
		{
			fast = fast.next.next;
			slow = slow.next;
		}

		ListNode second = slow.next;
		slow.next = null;

		second = reverse(second);

		merge(head, second);
	}

	private ListNode reverse(ListNode head)
	{
		if(head == null || head.next == null)
			return head;

		ListNode p = head;
		ListNode q = p.next;

		while(q != null)
		{
			ListNode t = q.next;
			q.next = p;
			p = q;
			q = t;
		}

		head.next = null;

		return p;
	}

	private ListNode merge(ListNode l1, ListNode l2)
	{
		if(l1 == null)
			return l2;

		if(l2 == null)
			return l1;

		ListNode dummyNode = new ListNode(0);
		ListNode p = dummyNode;

		while(l1 != null && l2 != null)
		{
			p.next = l1;
			l1 = l1.next;
			p = p.next;
			p.next = l2;
			l2 = l2.next;
			p = p.next;
		}

		if(l1 != null)	p.next = l1;
		if(l2 != null)	p.next = l2;

		return dummyNode.next;
	}
}