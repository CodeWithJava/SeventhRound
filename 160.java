public class Solution
{
	public ListNode getIntersectionNode(ListNode headA, ListNode headB)
	{
		if(headA == null || headB == null)
			return null;

		ListNode p = headA;
		int m = 0;

		while(p != null)
		{
			m++;
			p = p.next;
		}

		ListNode q = headB;
		int n = 0;

		while(q != null)
		{
			n++;
			q = q.next;
		}

		p = headA;
		q = headB;

		if(m - n > 0)
		{
			for(int i = 0;i < m - n;i++)
				p = p.next;
		}
		else
		{
			for(int i = m - n;i < 0;i++)
				q = q.next;
		}

		while(p != null)
		{
			if(p == q)
				return p;

			p = p.next;
			q = q.next;
		}

		return null;
	}
}
