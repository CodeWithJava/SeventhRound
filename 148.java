public class Solution
{
	public ListNode sortList(ListNode head)
	{
		if(head == null || head.next == null)
			return head;

		ListNode p = head;
		int x = 0;

		while(p != null)
		{
			x++;
			p = p.next;
		}

		ListNode l = head;
		ListNode r = null;

		int half = x / 2;

		p = head;

		while(p != null)
		{
			if(--half == 0)
			{
				r = p.next;
				p.next = null;
				break;
			}

			p = p.next;
		}

		ListNode h1 = sortList(l);
		ListNode h2 = sortList(r);

		return merge(h1, h2);
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
			if(l1.val < l2.val)
			{
				p.next = l1;
				l1 = l1.next;
			}
			else
			{
				p.next = l2;
				l2 = l2.next;
			}

			p = p.next;
		}

		if(l1 != null)	p.next = l1;
		if(l2 != null)	p.next = l2;

		return dummyNode.next;
	}
}