public class Solution
{
	public ListNode reverseList(ListNode head)
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
}