public class Solution
{
	public ListNode partition(ListNode head, int x)
	{
		if(head == null || head.next == null)
			return head;

		ListNode dummyNode1 = new ListNode(0);
		dummyNode1.next = head;
		ListNode less = dummyNode1;

		ListNode dummyNode2 = new ListNode(0);
		ListNode more = dummyNode2;

		ListNode p = head;

		while(p != null)
		{
			if(p.val < x)
				less = less.next;
			else
			{
				more.next = p;
				more = more.next;
				less.next = p.next;
			}

			p = p.next;
		}

		less.next = dummyNode2.next;
		more.next = null;

		return dummyNode1.next;
	}
}